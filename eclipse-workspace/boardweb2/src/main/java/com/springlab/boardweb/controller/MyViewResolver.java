package com.springlab.boardweb.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class MyViewResolver {
	
	private String prefix = "";
	private String suffix = "";
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String resolve(String viewName) {
		return (new StringBuffer()).append(prefix).append(viewName).append(suffix).toString();
	}
	
}
