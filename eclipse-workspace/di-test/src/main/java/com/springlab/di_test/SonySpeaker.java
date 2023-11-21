package com.springlab.di_test;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {

	
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker - 소리를 올린다.");

	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker - 소리를 내린다.");

	}

}
