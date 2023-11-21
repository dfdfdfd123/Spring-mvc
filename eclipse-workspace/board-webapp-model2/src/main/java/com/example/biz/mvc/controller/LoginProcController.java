package com.example.biz.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.biz.user.UserDO;
import com.example.biz.user.UserService;
import com.example.biz.user.UserServiceImpl;

public class LoginProcController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ���� ó�� 
		UserDO vo = new UserDO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserService userService = new UserServiceImpl();
		UserDO user = userService.getUser(vo);
		if (user != null && !user.getPassword().equals(password))
		{
			user = null;
		}
		
		// 3. ȭ�� �׺���̼�
		
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


