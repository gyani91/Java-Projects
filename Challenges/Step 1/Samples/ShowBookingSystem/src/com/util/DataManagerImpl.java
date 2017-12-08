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

public class DataManagerImpl implements DataManager {

	public List<Show> populateDataFromFile(String fileName) {
		
		List<Show> list=new ArrayList<Show>();
		
		ObjectInputStream in=null;
		try {
			 in=new ObjectInputStream(new FileInputStream(fileName));
			 Show s=null;
			 while((s=(Show)in.readObject())!=null){
			
				list.add(s);
		
				
			 }		
			 
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public void bookShow(List<Show> showList, String showName,
			String show_time, int noOfSeats) throws SeatsNotAvailableException,
			UnknownShowException, InvalidSeatNumberException {
		if( noOfSeats <=0)
			throw new InvalidSeatNumberException();
		
		for(Show show:showList){
			if(show.getShowName().equals(showName)){
				if(noOfSeats<show.getSeatsAvailable()){
					show.setSeatsAvailable(show.getSeatsAvailable()-noOfSeats);
					return;
				}
				else
					throw new SeatsNotAvailableException();
			}
		}
		throw new UnknownShowException();
		
	}
}
