package com.springlab.di_test;

public class SamsungTV {
	
	public void powerOn() {
		System.out.println("SamsungTV - ������ �Ҵ�.");
		
	}
	
	public void powerOff() {
		System.out.println("SamsungTV - ������ ����.");
		
	}
		
		public void volumeUp() {
			System.out.println("SamsungTV - �Ҹ��� �ø���.");
			
		}
		
		public void volumeDown() {
			System.out.println("SamsungTV - �Ҹ��� ������.");
			
		}

		@Override
		public String toString() {
			return "SamsungTV [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}
		
		
		
	}


