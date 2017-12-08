package com.psl;

import java.util.List;
import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;
import com.util.DataManager;
import com.util.DataManagerImpl;

public class Client {
	public static void main(String[] args) {
		
		DataManager demo = new DataManagerImpl();

		List<Show> list = demo.populateDataFromFile("ShowDetails.ser");
		System.out.println(list);
		try {
			demo.bookShow(list, "Sahi re Sahi", "6:30 PM", 20);

			demo.bookShow(list, "Sahi re Sahi", "6:30 PM", 0);

			demo.bookShow(list, "sdeff", "6:30 PM", 5);
		} catch (SeatsNotAvailableException e) {
			e.printStackTrace();
		} catch (UnknownShowException e) {
			e.printStackTrace();
		} catch (InvalidSeatNumberException e) {
			e.printStackTrace();
		}
	}
}
