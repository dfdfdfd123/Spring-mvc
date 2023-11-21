package com.example.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserJdbcDAO();
	}	
	
	public void insertUser(UserDO user) {
		dao.insertUser(user);
	}

	public void updateUser(UserDO user) {
		dao.updateUser(user);
	}

	public void deleteUser(UserDO user) {
		dao.deleteUser(user);
	}

	public UserDO getUser(UserDO user) {
		return dao.getUser(user);
	}

	public List<UserDO> listUser() {
		return dao.listUser();
	}

}
