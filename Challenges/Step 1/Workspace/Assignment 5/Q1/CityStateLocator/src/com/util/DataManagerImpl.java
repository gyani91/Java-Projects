package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;


// Override and implement the methods of Interface DataManager here 
public class DataManagerImpl implements DataManager 
{

	@Override
	public Map<String, List<String>> populateCityDataMap(String fileName)
			throws FileNotFoundException 
	{
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		InputStreamReader isr = new InputStreamReader(dis);
		BufferedReader br = new BufferedReader(isr);
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		try
		{
			for(String line = br.readLine(); line != null; line = br.readLine())
			{
				List<String> edit = new ArrayList<String>();		

				if(!line.trim().equals(""))
				{
					String data[] = line.split("-", 2);
					if(map.containsKey(data[0]))
					{
						edit = map.get(data[0]);
						if(!edit.contains(data[1]))
						{
							edit.add(data[1]);
						}
						map.put(data[0], edit);
					}
					else
					{
						edit.add(data[1]);
						map.put(data[0], edit);
					}
					
				}
				
			}
			br.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		if(map.isEmpty())
		{
			return null;
		}
		return map;

	}

	@Override
	public List<String> getCities(Map<String, List<String>> stateCityMap,
			String state) throws InvalidStateException 
	{
		if(stateCityMap.containsKey(state))
		{
			return stateCityMap.get(state);
		}
		else
		{
			throw new InvalidStateException();
		}
	}

	@Override
	public String getState(Map<String, List<String>> stateCityMap, String city)
			throws CityNotFoundException
	{
		for(Map.Entry<String, List<String>> entry  : stateCityMap.entrySet())
		{
			if(entry.getValue().contains(city))
			{
				return entry.getKey();
			}
		}
		
		throw new CityNotFoundException();
	}

}
