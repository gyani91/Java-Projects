package com.psl;

import java.util.List;

import com.bean.Item;
import com.exception.NoDataFoundException;
import com.util.InventoryService;
import com.util.InventoryServiceImpl;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InventoryService demo=new InventoryServiceImpl();
		
		List<Item> list= demo.readAllItemsFromDb();
		
		for(Item i:list)
		{
			System.out.println(i);
		}
		demo.calculateExpiryDate(list);	
		
		demo.removeExpiredItems(list);
				
		demo.sortItems(list);
				
		demo.applyDiscount(list);
		
		System.out.println(" Searched list ");
		try {
			List<Item> lst= demo.searchItem("Milk",list);
			for(Item i:lst)
			{
				System.out.println(i);
			}
				
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		}
	}

}
