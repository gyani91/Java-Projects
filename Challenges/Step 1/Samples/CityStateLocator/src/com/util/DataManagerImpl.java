package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;

public class DataManagerImpl implements DataManager {

	@Override
	public List<String> getCities(Map<String, List<String>> stateCityMap,
			String state) throws InvalidStateException {
		if (stateCityMap.containsKey(state))
			return stateCityMap.get(state);
		else
			throw new InvalidStateException();
	}

	@Override
	public String getState(Map<String, List<String>> stateCityMap, String city)
			throws CityNotFoundException {
		boolean foundflag = false;
		Set<String> states = stateCityMap.keySet();
		Iterator<String> itr = states.iterator();
		String state = null;
		while (itr.hasNext()) {
			state = itr.next();
			List<String> cityList = stateCityMap.get(state);
			if (cityList.contains(city)) {
				foundflag = true;
				break;
			}
		}
		if (!foundflag)
			throw new CityNotFoundException();

		return state;
	}

	@Override
	public Map<String, List<String>> populateCityDataMap(String fileName)
			throws FileNotFoundException {

		Map<String, List<String>> cityStateMap = new HashMap<String, List<String>>();
		Scanner scr = null;

		scr = new Scanner(new File(fileName));
		while (scr.hasNext()) {
			String line = scr.nextLine();
			String data[] = line.split("-");
			if (cityStateMap.containsKey(data[0].trim())) {
				cityStateMap.get(data[0].trim()).add(data[1].trim());
			} else {
				List<String> cityList = new ArrayList<String>();
				cityList.add(data[1].trim());
				cityStateMap.put(data[0].trim(), cityList);
			}
		}

		return cityStateMap;
	}

}
