package com.imooc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.UsersExample;
import com.imooc.pojo.UsersExample.Criteria;
import com.imooc.service.UsersService;
import com.imooc.utils.PagedResult;


@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper userMapper;

	@Override
	public PagedResult queryUsers(Users user, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		String username = "";
		String nickname = "";

		if (user != null) {
			username = user.getUsername();
			nickname = user.getNickname();
		}

		PageHelper.startPage(page, pageSize);

		UsersExample userExample = new UsersExample();
		Criteria userCriteria = userExample.createCriteria();
		if (StringUtils.isNotBlank(username)) {
			userCriteria.andUsernameLike("%" + username + "%");
		}
		if (StringUtils.isNotBlank(nickname)) {
			userCriteria.andNicknameLike("%" + nickname + "%");
		}

		List<Users> userList = userMapper.selectByExample(userExample);
		PageInfo<Users> pageList = new PageInfo<Users>(userList);

		PagedResult grid = new PagedResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(userList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());

		return grid;

	}

}
