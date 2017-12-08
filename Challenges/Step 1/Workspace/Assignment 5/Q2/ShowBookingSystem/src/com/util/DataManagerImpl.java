package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;

//Override and implement all the methods of DataManger Interface in this class
public class DataManagerImpl implements DataManager
{

	public List<Show> populateDataFromFile(String fileName) 
	{
		List<Show> list = new ArrayList<Show>();
		ObjectInputStream ois;
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			Show show = (Show)ois.readObject();
			while(fis.available() > 0)
			{
				list.add(show);
				show = (Show)ois.readObject();
			}
			ois.close();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
		{
			return null;
		}
		
		return list;
		
	}

	public void bookShow(List<Show> showList, String showName,
			String show_time, int noOfSeats) throws SeatsNotAvailableException,
			UnknownShowException, InvalidSeatNumberException 
	{
		if(noOfSeats <=0)
		{
			throw new InvalidSeatNumberException();
		}
		for(Show show : showList)
		{
			if(show.getShowName().equals(showName))
			{
				if(show.getShowTime().equals(show_time))
				{
					if(show.getSeatsAvailable() >= noOfSeats)
					{
						System.out.println("Tickets Booked!!");
						return;
					}
					else
					{
						throw new SeatsNotAvailableException();
					}
				}
			}
		}
		throw new UnknownShowException();
	}
	
}
