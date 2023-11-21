package com.springlab.di_test;

import org.springframework.stereotype.Component;

@Component("boss")
public class BossSpeaker implements Speaker {

	@Override
	public void volumeUp() {
		System.out.println("BossSpeaker - 소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("BossSpeaker - 소리를 내린다.");

	}

}
