package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.UsersReport;

public interface UserService {

	public boolean quertUsernameIsExist(String username);

	public void saveUser(Users user);

	public Users queryUserForLogin(String username, String password);

	public void updateUserInfo(Users user);

	public Users queryUserInfo(String userId);

	public boolean isUserLikeVideo(String userId, String videoId);

	public void saveUserFanRelation(String userId, String fanId);

	public void deleteUserFanRelation(String userId, String fanId);

	public boolean queryIfFollow(String userId, String fanId);

	public void reportUser(UsersReport userReport);

}
