package com.springlab.di_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("samsung")
@Lazy(true)
public class SamsungTV2 implements TV {
	
	
	@Autowired
	@Qualifier("boss")
	private Speaker speaker;
	@Value("Samsung Neo QLED-75")
	private String modelName;
	@Value("3000000")
	private int price;
	
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
	//	System.out.println("SamsungTV - 소리를 올린다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
	//	System.out.println("SamsungTV - 소리를 내린다.");
		speaker.volumeDown();

	}

}
