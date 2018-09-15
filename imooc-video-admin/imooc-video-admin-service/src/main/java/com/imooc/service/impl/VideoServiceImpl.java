package com.imooc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.enums.BGMOperatorTypeEnum;
import com.imooc.mapper.BgmMapper;
import com.imooc.mapper.UsersReportMapperCustom;
import com.imooc.mapper.VideosMapper;
import com.imooc.pojo.Bgm;
import com.imooc.pojo.BgmExample;
import com.imooc.pojo.Videos;
import com.imooc.pojo.vo.Reports;
import com.imooc.service.VideoService;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.PagedResult;
import com.imooc.web.util.ZKCurator;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private 
	@Override
	public void addBgm(Bgm bgm) {
		// TODO Auto-generated method stub

	}

	@Override
	public PagedResult queryBgmList(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBgm(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public PagedResult queryReportList(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVideosStatus(String videoId, Integer status) {
		// TODO Auto-generated method stub

	}

}
