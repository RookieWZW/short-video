package com.imooc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.enums.VideoStatusEnum;
import com.imooc.pojo.Bgm;
import com.imooc.service.VideoService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.PagedResult;

@Controller
@RequestMapping("video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@GetMapping("/showReportList")
	public String showReportList() {
		return "video/reportList";
	}

	@PostMapping("/reportList")
	@ResponseBody
	public PagedResult reportList(Integer page) {
		PagedResult result = videoService.queryReportList(page, 10);

		return result;
	}

	@PostMapping("/forbidVideo")
	@ResponseBody
	public IMoocJSONResult forbidVideo(String videoId) {
		videoService.updateVideosStatus(videoId, VideoStatusEnum.FORBID.value);
		;

		return IMoocJSONResult.ok();
	}

	@GetMapping("/showBgmList")
	public String showBgmList() {
		return "video/bgmList";
	}

	@PostMapping("/queryBgmList")
	@ResponseBody
	public PagedResult queryBgmList(Integer page) {
		return videoService.queryBgmList(page, 10);
	}

	@GetMapping("/showAddBgm")
	public String login() {
		return "video/addBgm";
	}

	@PostMapping("/addBgm")
	@ResponseBody
	public IMoocJSONResult addBgm(Bgm bgm) {

		videoService.addBgm(bgm);
		return IMoocJSONResult.ok();
	}

	@PostMapping("/delBgm")
	@ResponseBody
	public IMoocJSONResult delBgm(String bgmId) {
		videoService.deleteBgm(bgmId);
		return IMoocJSONResult.ok();
	}

	@PostMapping("/bgmUpload")
	@ResponseBody
	public IMoocJSONResult bgmUpload(@RequestParam("file") MultipartFile[] files) throws Exception {

		String fileSpace = "F:" + File.separator + "imooc-video-workspace" + File.separator + "imooc_video_dev"
				+ File.separator + "mvc-bgm";
		String uploadPathDB = File.separator + "bgm";

		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			if (files != null && files.length > 0) {

				String fileName = files[0].getOriginalFilename();
				if (StringUtils.isNotBlank(fileName)) {
					// 文件上传的最终保存路径
					String finalPath = fileSpace + uploadPathDB + File.separator + fileName;
					// 设置数据库保存的路径
					uploadPathDB += (File.separator + fileName);

					File outFile = new File(finalPath);
					if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
						// 创建父文件夹
						outFile.getParentFile().mkdirs();
					}

					fileOutputStream = new FileOutputStream(outFile);
					inputStream = files[0].getInputStream();
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

		return IMoocJSONResult.ok(uploadPathDB);
	}

}
