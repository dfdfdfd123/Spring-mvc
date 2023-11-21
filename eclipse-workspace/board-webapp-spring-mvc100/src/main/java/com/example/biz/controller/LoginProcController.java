package com.example.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.biz.user.UserDO;
import com.example.biz.user.UserService;

public class LoginProcController implements Controller {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserDO vo = new UserDO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDO user = userService.getUser(vo);
		if (!user.getPassword().equals(password)) {
			user = null;
		}
		
		// 3. 화면 네비게이션
		ModelAndView mv = new ModelAndView();
		if (user != null) {
			mv.setViewName("redirect:get_board_list.do");
		}
		else {
			mv.setViewName("redirect:login.do");
		}
		
		return mv;
	}

}
