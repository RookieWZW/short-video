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


@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideosMapper videosMapper;

	@Autowired
	private BgmMapper bgmMapper;

	@Autowired
	private Sid sid;

	

	@Autowired
	private UsersReportMapperCustom usersReportMapperCustom;

	@Override
	public void addBgm(Bgm bgm) {
		// TODO Auto-generated method stub
		String bgmId = sid.nextShort();
		bgm.setId(bgmId);
		bgmMapper.insert(bgm);

		Map<String, String> map = new HashMap<>();

		map.put("operType", BGMOperatorTypeEnum.ADD.type);
		map.put("path", bgm.getPath());

		//zkCurator.sendBgmOperator(bgmId, JsonUtils.objectToJson(map));
	}

	@Override
	public PagedResult queryBgmList(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);

		BgmExample example = new BgmExample();
		List<Bgm> list = bgmMapper.selectByExample(example);

		PageInfo<Bgm> pageList = new PageInfo<>(list);

		PagedResult result = new PagedResult();
		result.setTotal(pageList.getPages());
		result.setRows(list);
		result.setPage(page);
		result.setRecords(pageList.getTotal());

		return result;

	}

	@Override
	public void deleteBgm(String id) {
		// TODO Auto-generated method stub
		Bgm bgm = bgmMapper.selectByPrimaryKey(id);

		bgmMapper.deleteByPrimaryKey(id);

		Map<String, String> map = new HashMap<>();
		map.put("operType", BGMOperatorTypeEnum.DELETE.type);
		map.put("path", bgm.getPath());

	//	zkCurator.sendBgmOperator(id, JsonUtils.objectToJson(map));

	}

	@Override
	public PagedResult queryReportList(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);

		List<Reports> reportsList = usersReportMapperCustom.selectAllVideoReport();

		PageInfo<Reports> pageList = new PageInfo<Reports>(reportsList);

		PagedResult grid = new PagedResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(reportsList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());

		return grid;
	}

	@Override
	public void updateVideosStatus(String videoId, Integer status) {
		// TODO Auto-generated method stub
		Videos video = new Videos();
		video.setId(videoId);
		video.setStatus(status);
		videosMapper.updateByPrimaryKeySelective(video);
	}

}
