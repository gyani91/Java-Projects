package com.psl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Client {

	public int findAge(String birthDate) throws InvalidDateFormatException {
		Date date = null;

		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setLenient(false);
			date = df.parse(birthDate);
		} catch (ParseException e) {
			throw new InvalidDateFormatException();
		}
		
		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(date);
		if (dob.after(now)) {
			return 0;
		} else {
			int year1 = now.get(Calendar.YEAR);
			int year2 = dob.get(Calendar.YEAR);
			System.out.println("y1 :" + year1);
			System.out.println("y2 :" + year2);
			int age = year1 - year2;
			System.out.println(age);
			int month1 = now.get(Calendar.MONTH);
			int month2 = dob.get(Calendar.MONTH);
			if (month2 > month1) {
				age--;
			} else if (month1 == month2) {
				int day1 = now.get(Calendar.DAY_OF_MONTH);
				int day2 = dob.get(Calendar.DAY_OF_MONTH);
				if (day2 > day1) {
					age--;
				}
			}
	
			return age;
		}
	}

	public static void main(String[] args) {

		Client age = new Client();
		try {
			System.out.println("Age : " + age.findAge("12-01-1982"));//("02-11-1970"));
		} catch (InvalidDateFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
