package com.example.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 세션 종료
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		// 2. 화면 네비게이션 - goto main view
		return new ModelAndView("redirect:login.do");				
	}

}
