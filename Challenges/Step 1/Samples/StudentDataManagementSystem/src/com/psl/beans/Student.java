package com.psl.beans;

public class Student implements  Comparable<Student> {
	private int rollno;
	private String studentName;
	private int age;
	private Address address;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(int rollno, String studentName, int age, Address address) {
		super();
		this.rollno = rollno;
		this.studentName = studentName;
		this.age = age;
		this.address = address;
	}
	@Override
	public int compareTo(Student s) {		
		int i= getStudentName().compareTo(s.getStudentName());
		if(i==0)
		{
			if(getAge()==s.getAge()){
				if(getRollno()<s.getRollno()){
					i=-1;
				}
				else if(getRollno()>s.getRollno())
				{
					i=1;
				}
				else
				{
					i=0;
				}
			}
			else if(getAge()<s.getAge()){
				i= -1;
			}
			else
			{
				i= 1;
			}
			
		}
		
			return i;
		
	}	
	
	@Override
	public String toString() {
		return "[ "+rollno+" , "+studentName+" , "+age+" , "+address +" ]";
	}
}
