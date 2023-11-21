package com.example.biz.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.biz.user.UserDO;
import com.example.biz.user.UserService;
import com.example.biz.user.UserServiceImpl;

public class LoginProcController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리 
		UserDO vo = new UserDO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserService userService = new UserServiceImpl();
		UserDO user = userService.getUser(vo);
		if (user != null && !user.getPassword().equals(password))
		{
			user = null;
		}
		
		// 3. 화면 네비게이션
		
		String viewName = null;
		if (user != null)
		{
			viewName = "redirect:get_voard_list_do";
		}
		else {
			viewName = "redirect:login.do";
		}
		
		return viewName;
		
		
	}

	
	}


