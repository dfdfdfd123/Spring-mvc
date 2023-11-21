package com.springlab.biz.user.impl;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.springlab.biz.user.UserService;
import com.springlab.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				com.springlab.biz.common.AppContextConfig.class);

		UserService userService = context.getBean(UserService.class);
		
		UserVO user = new UserVO();
		user.setId("gdhong2");
		user.setPassword("1234");
		user.setName("홍길동");
		user.setRole("user");
		userService.insertUser(user);
		
		List<UserVO> userList = userService.listUser();
		for (UserVO vo : userList) {
			System.out.println("사용자: " + vo.toString());
		}
		
		context.close();
	}

}
