package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlab.biz.user.UserService;
import com.springlab.biz.user.UserVO;

public class LoginProcController implements MyController {
	
	@Autowired
	private UserService userService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		UserVO user = userService.getUser(vo);
				
		// 3. ȭ�� �׺���̼�
		if (user != null && password.equals(user.getPassword())) {
			return "redirect:get_board_list";
		} else {
			return "login";
		}
	}

}
