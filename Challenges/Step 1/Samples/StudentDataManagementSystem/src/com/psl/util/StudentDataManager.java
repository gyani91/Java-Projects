package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.psl.beans.Address;
import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;

public class StudentDataManager implements DataManager {

	@Override
	public List<Student> populateData(String fileName) {
		Exception ex = null;
		boolean exceptionFlag = false;
		List<Student> studentList=new ArrayList<Student>();
		File file = new File(fileName);
		Scanner scr;
		String[] studentData;
		try {
			scr = new Scanner(file);

			while (scr.hasNext()) {

				String data = scr.nextLine();
				studentData = data.split(",");
				Student student = new Student();
				// if rollno not present then assign 0
				if (studentData[0].trim().length() > 0) {
					student.setRollno(Integer.parseInt(studentData[0]));
				} else
					student.setRollno(0);
				// studentName
				if (studentData[1].trim().equals(""))
					student.setStudentName(null);
				else
					student.setStudentName(studentData[1]);
				
				//Age
				
				if (studentData[2].trim().length() > 0) {
					student.setAge(Integer.parseInt(studentData[2]));
				} else
					student.setAge(0);
				Address address=new Address();
				// Address - street 
				if (studentData[3].trim().equals(""))
					address.setStreetName(null);
				else
					address.setStreetName(studentData[3].trim());
				
				
				//Address - city
				if (studentData[4].trim().equals(""))
					address.setCity(null);
				else
					address.setCity(studentData[4].trim());
				
				//Address - ZipCode
				if (studentData[5].trim().equals(""))
					address.setCity(null);
				else
					address.setZipCode(studentData[5].trim());
				
				
				student.setAddress(address);
				studentList.add(student);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//studentList=null;
		return studentList;

	}

	@Override
	public void sortData(List<Student> studentList) {
		Collections.sort(studentList);
	}

	@Override
	public void validateData(List<Student> studentList)
			throws InsufficientDataException {
		Iterator<Student> it = studentList.iterator();
		boolean exceptionFlag = false;
		while (it.hasNext()) {
			try {
				Student s = it.next();
				
				if(s == null || (s.getRollno() == 0 || s.getStudentName() == null
						|| s.getAge() == 0 || s.getAddress().getStreetName() == null || s.getAddress().getCity()==null || s.getAddress().getZipCode()==null)) {
					it.remove();
					throw new InsufficientDataException();
				}

			} catch (InsufficientDataException e) {
				exceptionFlag = true;
			}
		}
		if (exceptionFlag)
			throw new InsufficientDataException();

	}

}
