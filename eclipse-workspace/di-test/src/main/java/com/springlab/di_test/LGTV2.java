package com.springlab.di_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("lg")
@Lazy(true)
public class LGTV2 implements TV {
	
	
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	@Value("LG QLED-60")
	private String modelName;
	@Value("3500000")
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
		System.out.println("LgTV - 전원을 켠다.");

	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원을 끈다.");

	}

	@Override
	public void volumeUp() {
	//	System.out.println("LgTV - 소리를 올린다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
	//	System.out.println("LgTV - 소리를 내린다.");
		speaker.volumeDown();

	}

	@Override
	public String toString() {
		return "LGTV2 [speaker=" + speaker + ", modelName=" + modelName + ", price=" + price + "]";
	}
	
	

}
