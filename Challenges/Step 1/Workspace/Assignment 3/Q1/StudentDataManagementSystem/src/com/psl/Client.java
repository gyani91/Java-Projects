package com.psl;

import java.util.List;

import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;
import com.psl.util.StudentDataManager;


public class Client {
	
	public static void main(String[] args) 
	{
		
		//Create instance of StudentDataManager Class here and  test your functionality from here
		StudentDataManager demo = new StudentDataManager();
		List<Student> list = demo.populateData("StudentDetails.txt");
		try
		{
			demo.validateData(list);
		}
		catch(InsufficientDataException e)
		{
			System.out.println("Insufficient Data Exception Caught");
		}
		System.out.println("\n\n\n>>>>>>>\n");

		demo.sortData(list);
	}
}
