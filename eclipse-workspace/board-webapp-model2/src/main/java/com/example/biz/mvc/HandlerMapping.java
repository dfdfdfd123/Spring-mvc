package com.example.biz.mvc;

import java.util.Map;
import java.util.HashMap;

import com.example.biz.mvc.controller.*;
import com.example.biz.mvc.controller.LoginController;


public class HandlerMapping {
	
	private Map<String, Controller> mapping = null;
	
	public HandlerMapping()
	{
		mapping = new HashMap<String, Controller>();
		
		mapping.put("/login.do", new LoginController());
		mapping.put("/login.do", new LoginProcController());
	}
	
	public Controller getController(String path) {
		// TODO Auto-generated method stub
		return mapping.get(path);
	}


	
}
