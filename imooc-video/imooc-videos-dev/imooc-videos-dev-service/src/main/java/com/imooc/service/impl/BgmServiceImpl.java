package com.imooc.service.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.mapper.BgmMapper;
import com.imooc.pojo.Bgm;
import com.imooc.service.BgmService;

@Service
public class BgmServiceImpl implements BgmService {
	
	@Autowired
	private BgmMapper bgmMapper;
	
	@Autowired
	private Sid sid;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Bgm> queryBgmList() {
		// TODO Auto-generated method stub
		return bgmMapper.selectAll();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Bgm queryBgmById(String bgmId) {
		// TODO Auto-generated method stub
		return bgmMapper.selectByPrimaryKey(bgmId);
	}

}
