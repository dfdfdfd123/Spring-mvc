package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

}
