package com.psl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Cheese;
import com.bean.Item;
import com.bean.Milk;
import com.bean.Wheat;
import com.exception.NoDataFoundException;
import com.util.InventoryServiceImpl;

public class Client {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		// Call all the functionalities from here to test your code.
		List<Item> list = new ArrayList<Item>();
		List<Item> found = new ArrayList<Item>();
		
		InventoryServiceImpl test = new InventoryServiceImpl();
		
		list = test.readAllItemsFromDb();
		
		test.calculateExpiryDate(list);
		System.out.println("Size before removing: " + list.size());
		
		test.removeExpiredItems(list);
		System.out.println("Size after removing: " + list.size());

		test.sortItems(list);
		
		test.applyDiscount(list);
		
		try 
		{
			found = test.searchItem("Wheat", list);
		} 
		catch (NoDataFoundException e) 
		{
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		for(Item item : found)
		{
			System.out.println(item.getId()+item.getDescription()+item.getWeight()
					+item.getPrice()+item.getManufacturingDate()+item.getUseBeforeMonths()
					+item.getExpiryDate());
			
			if(item.getClass() == Cheese.class)
			{
				Cheese cheese = (Cheese) item;
				System.out.println(cheese.getCheeseType());
			}
			if(item instanceof Milk)
			{
				Milk milk = (Milk) item;
				System.out.println(milk.getMilkpacket() + String.valueOf(milk.getFatRate()));
			}
			if(item instanceof Wheat)
			{
				Wheat wheat = (Wheat) item;
				System.out.println(wheat.getWheatType());
			}
		}
		
	}
		
}
