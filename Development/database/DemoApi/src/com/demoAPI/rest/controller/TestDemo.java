package com.demoAPI.rest.controller;

import java.math.BigDecimal;

public class TestDemo {

	public static void main(String[] args) {
		
		
		 	String str="200.";
			System.out.println("praveen: "+str);
			BigDecimal bt=  new BigDecimal(str);
			bt = bt.setScale(0, BigDecimal.ROUND_HALF_UP);
			System.out.println("" + bt);
		
	}
}
