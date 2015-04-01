package com.munkhbat.minijava.temp;

/**
 * @author munkhbat
 * represents register
 */
public class Temp {
	private static int count;
	private int num;
	
	public String toString() {
		return "t" + num;
	}
	
	public Temp() {
		num = count++;
	}
}
