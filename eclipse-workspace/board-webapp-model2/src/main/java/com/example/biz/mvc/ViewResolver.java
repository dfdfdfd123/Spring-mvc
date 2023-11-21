package com.example.biz.mvc;

public class ViewResolver {
	
	private String prefix="";
	private String suffix="";
	
	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}
	
	public void setSuffix(String prefix)
	{
		this.suffix = suffix;
	}
	
	public String resolve(String viewName)
	{
		return prefix + viewName + suffix;
	}
	
	

}
