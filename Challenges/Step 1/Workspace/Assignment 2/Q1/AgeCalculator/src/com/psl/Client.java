package com.psl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Client {

	
	public int findAge(String birthDate) throws InvalidDateFormatException 
	{
		//Write a code here to calculate the age using the birthdate
		String dateFormat = "dd-MM-yyyy";
		int age;
		if(birthDate == null)
		{
			return 0;
		}
 
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
 
		try 
		{
			Date date = sdf.parse(birthDate);
			Calendar dob = Calendar.getInstance();  
			dob.setTime(date);  
			Calendar today = Calendar.getInstance();
			if (dob.after(today)) 
			{
				return 0;
			}
			age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
			if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) 
			{
			  age--;  
			} 
			else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
			    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) 
			{
			  age--;  
			}
			if(age==0)
			{
				age=1;
			}
			//if not valid, it will throw ParseException
			
		} 
		catch (ParseException e) 
		{
			throw new InvalidDateFormatException("Please enter date in dd-MM-yyyy format");
		}
		
		return age;
 
	}

	public static void main(String[] args)
	{
		Client demo =  new Client();
		try
		{
			System.out.println(demo.findAge("28-05-2014"));
		}
		catch(InvalidDateFormatException e)
		{
			System.out.println("Exception Caught!!");
		}
		
	}

}
