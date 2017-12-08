package com.psl;

public class Client {

	public boolean isLeapYear(int year) {
		boolean isLeapYear  = false;
		if(year <= 0) {
			return isLeapYear;
		}
		if ((year % 4) == 0) {
			if((year % 400) == 0){
				isLeapYear = true;
			} else if((year % 100) == 0) {
				isLeapYear= false;
			} else {
				isLeapYear = true;
			}
		}
		
		return isLeapYear;
	}

	public static void main(String[] args) {
		System.out.println(new Client().isLeapYear(2012));
		System.out.println(new Client().isLeapYear(2016));
		System.out.println(new Client().isLeapYear(2100));
		System.out.println(new Client().isLeapYear(2200));
		System.out.println(new Client().isLeapYear(2000));
		System.out.println(new Client().isLeapYear(2400));
	}

}
