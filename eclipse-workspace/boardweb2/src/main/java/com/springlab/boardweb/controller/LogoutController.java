package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
		request.getSession().invalidate();

		// 2. 세션 종료 후, 메인 화면으로 이동한다.
		return "login";
	}

}
