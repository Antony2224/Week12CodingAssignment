package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if( a >0 && b>0) {
			return a+b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	//Multiply two numbers
	public int multiplyNumber(int a, int b) {
		return a * b;
	}
	
	public int randomNumberSquared() {
		int x = getRandomInt();
		return x * x;
	}
	 int getRandomInt() {
		// TODO Auto-generated method stub
		Random random = new Random();
		return random.nextInt(10) +1;
	}
	
}
