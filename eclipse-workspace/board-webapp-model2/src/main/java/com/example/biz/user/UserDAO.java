package com.example.biz.user;

import java.util.List;

public interface UserDAO {

	void insertUser(UserDO user);
	
	void updateUser(UserDO user);
	
	void deleteUser(UserDO user);
	
	UserDO getUser(UserDO user);
	
	List<UserDO> listUser();
	
}
