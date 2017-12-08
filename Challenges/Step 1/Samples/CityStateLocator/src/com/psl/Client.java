package com.psl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.exception.InvalidStateException;
import com.exception.CityNotFoundException;
import com.util.DataManagerImpl;
import com.util.DataManager;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataManager demo=new DataManagerImpl();
		
		Map<String, List<String>> stateCityMap = null;
		try {
			stateCityMap = demo.populateCityDataMap("StateCityDetails.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(stateCityMap);
		
		try {
			String state=demo.getState(stateCityMap, "Mumbai");
			System.out.println(" State of  Mumbai  is :"+state);
		} catch (CityNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			List<String> cities=demo.getCities(stateCityMap, "Goa");
			System.out.println(" Cities in Goa "+cities);
		} catch (InvalidStateException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
