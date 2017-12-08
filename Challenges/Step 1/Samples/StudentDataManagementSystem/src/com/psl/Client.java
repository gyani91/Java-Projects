package com.psl;

import java.util.List;

import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;
import com.psl.util.StudentDataManager;

public class Client {
public static void main(String[] args)  {
	StudentDataManager obj=new StudentDataManager();
	List<Student> list=	obj.populateData("StudentDetails.txt");
	System.out.println(list);
	System.out.println("Populated list :"+list.size());
	//Validating List
	try {
		obj.validateData(list);
	} catch (InsufficientDataException e) {
		System.out.println(e.getMessage());
	}
	System.out.println(list);
	System.out.println("Validated list :"+list.size());
	obj.sortData(list);
	System.out.println(list);
	
	
}
}
