package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardController implements MyController {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "insertBoard";
	}

}
