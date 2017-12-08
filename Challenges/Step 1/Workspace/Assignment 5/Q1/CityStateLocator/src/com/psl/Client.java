package com.psl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;
import com.util.DataManagerImpl;


public class Client 
{
	
	public static void main(String[] args) 
	{
		DataManagerImpl test = new DataManagerImpl();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> cities  = new ArrayList<String>();

		try
		{
			map = test.populateCityDataMap("StateCityDetails.txt");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			cities = test.getCities(map, "Goa");
		}
		catch(InvalidStateException e) 
		{
			e.printStackTrace();
		}
				
		try
		{
			String state = test.getState(map, "Hyderabad");
			System.out.println(state);

		} 
		catch (CityNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(map);
		System.out.println(cities);
	}
}