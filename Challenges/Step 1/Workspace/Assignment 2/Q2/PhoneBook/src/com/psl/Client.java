package com.psl;

import java.util.ArrayList;
import java.util.Arrays;

import com.psl.exception.NoDataFoundException;
import com.psl.util.PhoneBookContacts;
import com.psl.util.PhoneBookContactsImpl;

public class Client {
	
	public static void main(String[] args)
	{
		
		//test your code by calling methods of the PhoneBookContacts from here
		PhoneBookContacts contacts=new PhoneBookContactsImpl();
		
		
		contacts.addContact("Gyani", new ArrayList<String>(Arrays.asList("1", "2", "3")));
		contacts.addContact("Gyani", new ArrayList<String>(Arrays.asList("5", "2")));
		contacts.addContact("Anjali", new ArrayList<String>(Arrays.asList("1000")));
		contacts.addContact("Rupal", new ArrayList<String>(Arrays.asList("b", "2", "a")));
		contacts.addContact("Munira", new ArrayList<String>(Arrays.asList("d", "2", "v")));
		
		System.out.println(contacts.getContactMap());
		
		try
		{
			System.out.println(contacts.searchContact("Anjali"));
		}
		catch(NoDataFoundException e)
		{
			System.out.println("Caught Exception");
		}

		
	}
}
