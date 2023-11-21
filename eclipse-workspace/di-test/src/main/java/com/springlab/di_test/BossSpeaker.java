package com.springlab.di_test;

import org.springframework.stereotype.Component;

@Component("boss")
public class BossSpeaker implements Speaker {

	@Override
	public void volumeUp() {
		System.out.println("BossSpeaker - �Ҹ��� �ø���.");
	}

	@Override
	public void volumeDown() {
		System.out.println("BossSpeaker - �Ҹ��� ������.");

	}

}
