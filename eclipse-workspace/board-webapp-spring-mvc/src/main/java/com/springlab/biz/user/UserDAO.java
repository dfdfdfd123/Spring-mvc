package com.springlab.biz.user;

import java.util.List;

public interface UserDAO {

	void insertUser(UserVO user);
	
	void updateUser(UserVO user);

	void deleteUser(UserVO user);

	UserVO getUser(UserVO user);

	List<UserVO> listUser();
	
}
