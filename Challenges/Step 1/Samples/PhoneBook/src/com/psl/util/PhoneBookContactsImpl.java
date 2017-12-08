package com.psl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psl.exception.NoDataFoundException;

public class PhoneBookContactsImpl implements PhoneBookContacts {

	private Map<String, List<String>> contactMap = new HashMap<String, List<String>>();
	
	
	
	@Override
	public void addContact(String name, List<String> list) {	
		contactMap.put(name, list);		
	}

	@Override
	public Map<String, List<String>> getContactMap() {
		// TODO Auto-generated method stub
		return contactMap;
	}

	@Override
	public List<String> searchContact(String name) throws NoDataFoundException {
		if(contactMap.containsKey(name)){
			return contactMap.get(name);
		}
		else {
			throw new NoDataFoundException();
		}
	}

}
