package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		request.getSession().invalidate();

		// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
		return "login";
	}

}
