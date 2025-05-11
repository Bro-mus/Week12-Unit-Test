package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		
		if (a > 0 && b > 0) {
		return a+b;
		
		} else { 
			throw new IllegalArgumentException( "These numbers are not positive");
		}
	}
	
 //method to reverse a string
	public String reverseString(String string) {
		if (string == null) {
			return null;

		}
		return new StringBuilder(string).reverse().toString();
	}

	public int randomNumberSquared() {
		int randomValue = getRandomInt();
		return randomValue * randomValue;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1; //per javadocs - Returns the next pseudorandom, 
    								//uniformly distributed int value from this 
    								//random number generator's sequence.
}

}
