package com.psl.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import com.psl.beans.Address;
import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;

//Override all the methods of the DataManager Interface
public class StudentDataManager implements DataManager 
{
	List<Student> list = new ArrayList<Student>();
	@Override
	public List<Student> populateData(String fileName) 
	{
		// TODO Auto-generated method stub
		
		try{
			
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			InputStreamReader isr = new InputStreamReader(dis);
			BufferedReader br = new BufferedReader(isr);
			
			for(String line = br.readLine(); line != null; line = br.readLine())
			{
				if(!line.trim().equals(""))
				{	
					Student student = new Student();
					Address address = new Address();

					String[] tokens = line.split(",", 6);
						
						student.setRollno(!(tokens[0].equals("") || tokens[0].equals(" ")) ? Integer.parseInt(tokens[0]) : 0);
						student.setStudentName(!(tokens[1].equals("") || tokens[1].equals(" ")) ? tokens[1] : null);
						student.setAge(!(tokens[2].equals("") || tokens[2].equals(" "))? Integer.parseInt(tokens[2]) : 0);
						address.setStreetName(!(tokens[3].equals("") || tokens[3].equals(" "))? tokens[3] : null);
						address.setCity(!(tokens[4].equals("") || tokens[4].equals(" "))? tokens[4]:null);
						address.setZipCode(!(tokens[5].equals("") || tokens[5].equals(" "))? tokens[5]:null);
						student.setAddress(address);
						list.add(student);
						System.out.println(student.getRollno() + student.getStudentName() + student.getAge()
								+student.getAddress().getCity() + student.getAddress().getStreetName()
								+student.getAddress().getZipCode());
				}
			}
			br.close();
			System.out.println(list.size());
			
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch(IOException e)
		{
			System.out.println("IOException Caught!!");

		}
		catch(PatternSyntaxException e)
		{
			System.out.println("Pattern Exception Caught!!");

		}
		return list;
	}

	@Override
	public void validateData(List<Student> studentList) throws InsufficientDataException 
	{
		// TODO Auto-generated method stub
		

		for(Student student : studentList)
		{
			try
			{
				System.out.println(student.getAddress().getCity() +
					   student.getAddress().getStreetName() +
					   student.getAddress().getZipCode() +
					   student.getStudentName() +
					   student.getAge() +
					   student.getRollno());
			if(student.getAddress().getCity() == null ||
			   student.getAddress().getStreetName() == null ||
			   student.getAddress().getZipCode() == null ||
			   student.getStudentName() == null ||
			   student.getAge() == 0 || 
			   student.getRollno() == 0)
			{
				System.out.println("Insufficient Data Exception Thrown");
				//studentList.remove(student);
				throw new InsufficientDataException();
			}
			}
			catch(InsufficientDataException e)
			{
				System.out.println("trial");
			}
				 
		}
		
	}

	@Override
	public void sortData(List<Student> studentList) 
	{
		// TODO Auto-generated method stub
		Collections.sort(studentList, new Comparator() {

	        public int compare(Object o1, Object o2) {

	            String x1 = ((Student) o1).getStudentName();
	            String x2 = ((Student) o2).getStudentName();
	            int sComp = x1.compareTo(x2);

	            if (sComp != 0) 
	            {
	               return sComp;
	            } 
	            else 
	            {
	               Integer x3 = ((Student) o1).getAge();
	               Integer x4 = ((Student) o2).getAge();
	               sComp = x3.compareTo(x4);
	               if (sComp != 0) 
		           {
		               return sComp;
		           } 
		           else 
		           {
		               Integer x5 = ((Student) o1).getRollno();
		               Integer x6 = ((Student) o2).getRollno();
		               return x5.compareTo(x6);
		               
		           }
	            }
	        }   
	    });
		
		for(Student student : studentList)
		{
			System.out.println(student.getAddress().getCity() +
					   student.getAddress().getStreetName() +
					   student.getAddress().getZipCode() +
					   student.getStudentName() +
					   student.getAge() +
					   student.getRollno());
		}
		
	}

	
}
