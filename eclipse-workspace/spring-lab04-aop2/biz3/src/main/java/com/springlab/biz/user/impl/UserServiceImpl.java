package com.springlab.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlab.biz.user.UserDAO;
import com.springlab.biz.user.UserService;
import com.springlab.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void insertUser(UserVO user) {
		userDAO.insertUser(user);
	}

	@Override
	public void updateUser(UserVO user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(UserVO user) {
		userDAO.deleteUser(user);
	}

	@Override
	public UserVO getUser(UserVO user) {
		return userDAO.getUser(user);
	}

	@Override
	public List<UserVO> listUser() {
		return userDAO.listUser();
	}

}
