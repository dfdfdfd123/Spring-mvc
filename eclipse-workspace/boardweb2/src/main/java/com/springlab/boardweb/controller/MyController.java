package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyController {

	String handleRequest(HttpServletRequest request, HttpServletResponse response);
	
}
