package com.springlab.di_test;

public class TVBeanFactory {
	
	public TV getBean(String beanName)
	{
		if (beanName.equals("samsung"))
		{
			return new SamsungTV2();
		}
		
		else if (beanName.equals("lg"))
		{
			return new LGTV2();
		}
		
		return null;
	}

}
