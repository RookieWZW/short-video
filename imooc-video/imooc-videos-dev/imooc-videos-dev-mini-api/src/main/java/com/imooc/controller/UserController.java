package com.imooc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.pojo.Users;
import com.imooc.pojo.UsersReport;
import com.imooc.pojo.vo.PublisherVideo;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.UserService;
import com.imooc.utils.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="用户相关业务的接口", tags= {"用户相关业务的controller"})
@RequestMapping("/user")
public class UserController extends BasicController{
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="用户上传头像", notes="用户上传头像的接口")
	@ApiImplicitParam(name="userId", value="用户id", required=true, 
						dataType="String", paramType="query")
	@PostMapping("/uploadFace")
	public IMoocJSONResult uploadFace(String userId,@RequestParam("file")MultipartFile[] files) throws IOException {
		if(StringUtils.isBlank(userId)) {
			return IMoocJSONResult.errorMsg("用户id不能为空...");
		}
		
		String fileSpace = "F:/imooc-video-workspace/imooc_video_dev";
		
		String uploadPathDB = "/" + userId + "/face";
		
		FileOutputStream fileOutputStream = null;
		
		InputStream inputStream = null;
		
		try {
			if(files!= null && files.length>0) {
				String fileName = files[0].getOriginalFilename();
				
				if(StringUtils.isNotBlank(fileName)) {
					String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
					uploadPathDB += ("/" + fileName);
					
					File outFile = new File(finalFacePath);
					if(outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
						outFile.getParentFile().mkdirs();
					}
					
					fileOutputStream = new FileOutputStream(outFile);
					
					inputStream = files[0].getInputStream();
					
					IOUtils.copy(inputStream, fileOutputStream);
				}
			}else {
				return IMoocJSONResult.errorMsg("上传出错...");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return IMoocJSONResult.errorMsg("上传出错...");
		}finally {
			if (fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
		
		Users user =new Users();
		
		user.setId(userId);
		user.setFaceImage(uploadPathDB);
		userService.updateUserInfo(user);
		
		return IMoocJSONResult.ok(uploadPathDB);
	}
	
	@ApiOperation(value="查询用户信息", notes="查询用户信息的接口")
	@ApiImplicitParam(name="userId", value="用户id", required=true, 
						dataType="String", paramType="query")
	@PostMapping("/query")
	public IMoocJSONResult query(String userId,String fanId)throws Exception{
		if (StringUtils.isBlank(userId)) {
			return IMoocJSONResult.errorMsg("用户id不能为空...");
		}
		
		Users userInfo = userService.queryUserInfo(userId);
		UsersVO userVO = new UsersVO();
		BeanUtils.copyProperties(userInfo, userVO);
		
		
		
		return IMoocJSONResult.ok(userVO);
	}
}
