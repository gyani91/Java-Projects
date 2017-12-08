package com.psl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psl.exception.NoDataFoundException;

//Override all the methods of the PhoneBookContacts Interface
public class PhoneBookContactsImpl implements PhoneBookContacts 
{

	// use this Map to create the PhoneBook Contacts
	private Map<String, List<String>> contactMap = new HashMap<String, List<String>>();

	@Override
	public void addContact(String name, List<String> list) 
	{
		// TODO Auto-generated method stub
		if(name!=null && list!=null)
			contactMap.put(name, list);
		
	}

	@Override
	public Map<String, List<String>> getContactMap() 
	{
		// TODO Auto-generated method stub
		return contactMap;
	}

	@Override
	public List<String> searchContact(String name) throws NoDataFoundException 
	{
		// TODO Auto-generated method stub
		List<String> test = contactMap.get(name);
		if(test==null)
			throw new NoDataFoundException();
		return test;
	}
	
	
	
	
	
}
