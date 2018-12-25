package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.utils.RedisOperator;

@RestController
public class BasicController {
	
	
	@Autowired
	public RedisOperator redis;
	
	
	public static final String USER_REDIS_SESSION = "user-redis-session";
	
	public static final String FILE_SPACE = "F:/imooc-video-workspace/imooc_video_dev";
	
	public static final String FFMPEG_EXE = "D:\\ffmpeg\\bin\\ffmpeg.exe";
	
	public static final Integer PAGE_SIZE = 5;
	
}
