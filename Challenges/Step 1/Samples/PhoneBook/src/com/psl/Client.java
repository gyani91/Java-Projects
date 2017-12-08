package com.psl;

import java.util.ArrayList;
import java.util.List;

import com.psl.exception.NoDataFoundException;
import com.psl.util.PhoneBookContacts;
import com.psl.util.PhoneBookContactsImpl;

public class Client {
	
	public static void main(String[] args){
		List<String> contacts=new ArrayList<String>();
		contacts.add("3342451234");
		contacts.add("3243434234");
		
		PhoneBookContacts contact=new PhoneBookContactsImpl();
		
		contact.addContact("Seema", contacts);
		
		contacts=new ArrayList<String>();
		contacts.add("2334234");
		contacts.add("7776654");
		contact.addContact("Reema",contacts);
		
		System.out.println("Entire Map :" + contact.getContactMap());
		
		try {
			System.out.println(" Seema's contact :" + contact.searchContact("Seema") );
			System.out.println(" Ria's contact (not available) :" + contact.searchContact("Ria") );
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
