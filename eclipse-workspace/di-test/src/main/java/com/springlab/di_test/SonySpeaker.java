package com.springlab.di_test;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {

	
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker - �Ҹ��� �ø���.");

	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker - �Ҹ��� ������.");

	}

}
