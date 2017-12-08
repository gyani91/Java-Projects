package com.psl;

public class Client {

	public boolean isLeapYear(int year) 
	{
		
		// Write your code here to test if the year passed as a parameter is a Leap Year or not.
		if(year%100 == 0)
        {
            if(year%400 == 0)
                return true;
            else
                return false;
        }
        else
        {
            if(year%4 == 0)
                return true;
            else
                return false;
        }

	}

	public static void main(String[] args) 
	{
		Client demo = new Client();
		System.out.println(demo.isLeapYear(2400));
	}

}
