package com.imooc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.enums.VideoStatusEnum;
import com.imooc.pojo.Bgm;
import com.imooc.pojo.Comments;
import com.imooc.pojo.Videos;
import com.imooc.service.BgmService;
import com.imooc.service.VideoService;
import com.imooc.utils.FetchVideoCover;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.MergeVideoMp3;
import com.imooc.utils.PagedResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "视频相关业务的接口", tags = { "视频相关业务的controller" })
@RequestMapping("/video")
public class VideoController extends BasicController {

	@Autowired
	private BgmService bgmService;

	@Autowired
	private VideoService videoService;

	@ApiOperation(value = "上传视频", notes = "上传视频的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "bgmId", value = "背景音乐id", required = false, dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "videoSeconds", value = "背景音乐播放长度", required = true, dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "videoWidth", value = "视频宽度", required = true, dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "videoHeight", value = "视频高度", required = true, dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "desc", value = "视频描述", required = false, dataType = "String", paramType = "form") })
	@PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
	public IMoocJSONResult upload(String userId, String bgmId, double videoSeconds, int videoWidth, int videoHeight,
			String desc, @ApiParam(value = "短视频", required = true) MultipartFile file) throws Exception {
		if (StringUtils.isBlank(userId)) {
			return IMoocJSONResult.errorMsg("用户id不能为空...");
		}

		String uploadPathDB = "/" + userId + "/video";
		String coverPathDB = "/" + userId + "/video";

		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		String finalVideoPath = "";

		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();

				String arrayFilenameItem[] = fileName.split("\\.");

				String fileNamePrefix = "";

				for (int i = 0; i < arrayFilenameItem.length; i++) {
					String string = arrayFilenameItem[i];
					fileNamePrefix += string;
				}

				if (StringUtils.isNotBlank(fileName)) {
					finalVideoPath = FILE_SPACE + uploadPathDB + "/" + fileName;

					uploadPathDB = coverPathDB + "/" + fileNamePrefix + ".jpg";

					File outFile = new File(finalVideoPath);
					if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
						outFile.getParentFile().mkdirs();
					}

					fileOutputStream = new FileOutputStream(outFile);

					inputStream = file.getInputStream();

					IOUtils.copy(inputStream, fileOutputStream);
				}
			} else {
				return IMoocJSONResult.errorMsg("上传出错...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return IMoocJSONResult.errorMsg("上传出错...");
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}

		if (StringUtils.isNotBlank(bgmId)) {
			Bgm bgm = bgmService.queryBgmById(bgmId);
			String mp3InputPath = FILE_SPACE + bgm.getPath();

			MergeVideoMp3 tool = new MergeVideoMp3(FFMPEG_EXE);

			String videoInputPath = finalVideoPath;

			String videoOutputName = UUID.randomUUID().toString() + ".mp4";

			uploadPathDB = "/" + userId + "/video" + videoOutputName;

			finalVideoPath = FILE_SPACE + uploadPathDB;

			tool.convertor(videoInputPath, mp3InputPath, videoSeconds, finalVideoPath);

		}
		System.out.println("uploadPathDB=" + uploadPathDB);
		System.out.println("finalVideoPath=" + finalVideoPath);

		FetchVideoCover videoInfo = new FetchVideoCover(FFMPEG_EXE);

		videoInfo.getCover(finalVideoPath, FILE_SPACE + coverPathDB);

		Videos video = new Videos();
		video.setAudioId(bgmId);
		video.setUserId(userId);
		video.setVideoSeconds((float) videoSeconds);
		video.setVideoHeight(videoHeight);
		video.setVideoWidth(videoWidth);
		video.setVideoDesc(desc);
		video.setVideoPath(uploadPathDB);
		video.setCoverPath(coverPathDB);
		video.setStatus(VideoStatusEnum.SUCCESS.value);
		video.setCreateTime(new Date());

		String videoId = videoService.saveVideo(video);

		return IMoocJSONResult.ok(videoId);

	}

	@ApiOperation(value = "上传封面", notes = "上传封面的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "videoId", value = "视频主键id", required = true, dataType = "String", paramType = "form") })
	@PostMapping(value = "/uploadCover", headers = "content-type=multipart/form-data")
	public IMoocJSONResult uploadCover(String userId, String videoId,
			@ApiParam(value = "视频封面", required = true) MultipartFile file) throws Exception {
		if (StringUtils.isBlank(videoId) || StringUtils.isBlank(userId)) {
			return IMoocJSONResult.errorMsg("视频主键id和用户id不能为空...");
		}

		String uploadPathDB = "/" + userId + "/video";

		FileOutputStream fileOutputStream = null;

		InputStream inputStream = null;
		String finalCoverPath = "";
		try {
			if (file != null) {

				String fileName = file.getOriginalFilename();
				if (StringUtils.isNotBlank(fileName)) {

					finalCoverPath = FILE_SPACE + uploadPathDB + "/" + fileName;

					uploadPathDB += ("/" + fileName);

					File outFile = new File(finalCoverPath);
					if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {

						outFile.getParentFile().mkdirs();
					}

					fileOutputStream = new FileOutputStream(outFile);
					inputStream = file.getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}

			} else {
				return IMoocJSONResult.errorMsg("上传出错...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return IMoocJSONResult.errorMsg("上传出错...");
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
		videoService.updateVideo(videoId, uploadPathDB);

		return IMoocJSONResult.ok();

	}

	@PostMapping(value = "/showAll")
	public IMoocJSONResult showAll(@RequestBody Videos video, Integer isSaveRecord, Integer page, Integer pageSize) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = PAGE_SIZE;
		}

		PagedResult result = videoService.getAllVideos(video, isSaveRecord, page, pageSize);

		return IMoocJSONResult.ok(result);
	}

	@PostMapping("/showMyFollow")
	public IMoocJSONResult showMyFollow(String userId, Integer page) {
		if (StringUtils.isBlank(userId)) {
			return IMoocJSONResult.ok();
		}
		if (page == null) {
			page = 1;
		}
		int pageSize = 6;

		PagedResult videosList = videoService.queryMyFollowVideos(userId, page, pageSize);

		return IMoocJSONResult.ok(videosList);
	}

	@PostMapping("/showMyLike")
	public IMoocJSONResult showMyLike(String userId, Integer page, Integer pageSize) {
		if (StringUtils.isBlank(userId)) {
			return IMoocJSONResult.ok();
		}

		if (page == null) {
			page = 1;
		}

		if (pageSize == null) {
			pageSize = 6;
		}

		PagedResult videosList = videoService.queryMyLikeVideos(userId, page, pageSize);

		return IMoocJSONResult.ok(videosList);
	}

	@PostMapping(value = "/hot")
	public IMoocJSONResult hot() throws Exception {
		return IMoocJSONResult.ok(videoService.getHotwords());
	}

	@PostMapping(value = "/userLike")
	public IMoocJSONResult userLike(String userId, String videoId, String videoCreaterId) throws Exception {
		videoService.userLikeVideo(userId, videoId, videoCreaterId);
		return IMoocJSONResult.ok();
	}

	@PostMapping(value = "/userUnLike")
	public IMoocJSONResult userUnLike(String userId, String videoId, String videoCreaterId) throws Exception {
		videoService.userUnLikeVideo(userId, videoId, videoCreaterId);
		return IMoocJSONResult.ok();
	}

	@PostMapping("/saveComment")
	public IMoocJSONResult saveComment(@RequestBody Comments comment, String fatherCommentId, String toUserId)
			throws Exception {

		comment.setFatherCommentId(fatherCommentId);
		comment.setToUserId(toUserId);

		videoService.saveComment(comment);
		return IMoocJSONResult.ok();
	}

	@PostMapping("/getVideoComments")
	public IMoocJSONResult getVideoComments(String videoId, Integer page, Integer pageSize) throws Exception {

		if (StringUtils.isBlank(videoId)) {
			return IMoocJSONResult.ok();
		}

		// 分页查询视频列表，时间顺序倒序排序
		if (page == null) {
			page = 1;
		}

		if (pageSize == null) {
			pageSize = 10;
		}

		PagedResult list = videoService.getAllComments(videoId, page, pageSize);

		return IMoocJSONResult.ok(list);
	}
}
