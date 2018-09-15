package com.imooc.service.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.mapper.UsersFansMapper;
import com.imooc.mapper.UsersLikeVideosMapper;
import com.imooc.mapper.UsersMapper;
import com.imooc.mapper.UsersReportMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.UsersFans;
import com.imooc.pojo.UsersReport;
import com.imooc.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersMapper userMapper;

	@Autowired
	private UsersFansMapper usersFansMapper;

	@Autowired
	private UsersLikeVideosMapper usersLikeVideosMapper;

	@Autowired
	private UsersReportMapper usersReportMapper;

	@Autowired
	private Sid sid;

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean quertUsernameIsExist(String username) {
		// TODO Auto-generated method stub
		Users user = new Users();

		user.setUsername(username);

		Users result = userMapper.selectOne(user);

		return result == null ? false : true;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub

		String userId = sid.nextShort();
		user.setId(userId);
		userMapper.insert(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Users queryUserForLogin(String username, String password) {
		// TODO Auto-generated method stub
		Example userExample = new Example(Users.class);

		Criteria criteria = userExample.createCriteria();

		criteria.andEqualTo("username", username);
		criteria.andEqualTo("password", password);

		Users result = userMapper.selectOneByExample(userExample);

		return result;

	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateUserInfo(Users user) {
		// TODO Auto-generated method stub
		Example userExample = new Example(Users.class);
		
		Criteria criteria = userExample.createCriteria();
		
		criteria.andEqualTo("id",user.getId());
		
		userMapper.updateByExampleSelective(user, userExample);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Users queryUserInfo(String userId) {
		// TODO Auto-generated method stub
		Example userExample = new Example(Users.class);
		Criteria criteria = userExample.createCriteria();
		criteria.andEqualTo("id", userId);
		Users user = userMapper.selectOneByExample(userExample);
		return user;
	}

	@Override
	public boolean isUserLikeVideo(String userId, String videoId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveUserFanRelation(String userId, String fanId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserFanRelation(String userId, String fanId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean queryIfFollow(String userId, String fanId) {
		// TODO Auto-generated method stub
		Example example = new Example(UsersFans.class);
		
		Criteria criteria = example.createCriteria();
		
		criteria.andEqualTo("userId",userId);
		criteria.andEqualTo("fanId",fanId);
		
		List<UsersFans> list = usersFansMapper.selectByExample(example);
		
		if (list != null && !list.isEmpty() && list.size() > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public void reportUser(UsersReport userReport) {
		// TODO Auto-generated method stub

	}

}
