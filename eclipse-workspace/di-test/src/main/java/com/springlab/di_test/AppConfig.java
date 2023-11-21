package com.springlab.di_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.springlab.di_test"})
public class AppConfig {

	@Autowired
	@Qualifier("boss")
	private Speaker speaker;
	
	@Bean
	public  TV samsung2()
	{
		// TV tv = new SamsungTV2();
		
		SamsungTV2 tv = new SamsungTV2();
		tv.setSpeaker(speaker);
		tv.setModelName("Samsung QLED-60");
		tv.setPrice(1700000);
		return null;
	}
	
	@Bean
	public  TV samsung3()
	{
		// TV tv = new SamsungTV2();
		
		SamsungTV2 tv = new SamsungTV2();
		tv.setSpeaker(speaker);
		tv.setModelName("Samsung QLED-60");
		tv.setPrice(1700000);
		return null;
	}
}
