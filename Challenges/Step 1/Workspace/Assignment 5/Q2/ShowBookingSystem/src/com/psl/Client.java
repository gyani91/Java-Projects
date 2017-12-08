package com.psl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;
import com.util.DataManagerImpl;

public class Client 
{
	
	public static void main(String[] args) 
	{
		DataManagerImpl test = new DataManagerImpl();
		List<Show> list = new ArrayList<Show>();
		
		list = test.populateDataFromFile("ShowDetails.ser");
		
		for(Show show : list)
		System.out.println(show.getSeatsAvailable() + show.getShowName()
				+show.getShowTime());
		
		try {
			test.bookShow(list, "All The Best", "6:30 PM", 40);
		} 
		catch (SeatsNotAvailableException e) 
		{
			e.printStackTrace();
		} 
		catch (UnknownShowException e) 
		{
			e.printStackTrace();
		} 
		catch (InvalidSeatNumberException e) 
		{
			e.printStackTrace();
		}
	}
}
