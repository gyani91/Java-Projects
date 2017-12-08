package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bean.Cheese;
import com.bean.CheeseType;
import com.bean.Ingred;
import com.bean.Item;
import com.bean.Milk;
import com.bean.MilkType;
import com.bean.Wheat;
import com.bean.WheatType;
import com.exception.NoDataFoundException;

// Override and implement all the methods of DBConnectionUtil Interface in this class
public class InventoryServiceImpl implements InventoryService 
{

	@Override
	public List<Item> readAllItemsFromDb() 
	{
		List<Item> list = new ArrayList<Item>();

		try
		{
			DatabaseConnectionManager dbcm = new DatabaseConnectionManager();
			Connection dbcon = dbcm.getConnection();
			Statement stmt = dbcon.createStatement();
			String query = "select * from cheese_tbl";
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) 
			{
				Cheese cheese = new Cheese();
				cheese.setId(result.getInt("id"));
				cheese.setDescription(result.getString("description"));
				cheese.setWeight(result.getFloat("weight"));
				cheese.setPrice(result.getFloat("price"));
				cheese.setManufacturingDate(result.getDate("mfg_date"));
				cheese.setUseBeforeMonths(result.getInt("UseBeforeInMonths"));
				cheese.setCheeseType(CheeseType.valueOf(result.getString("cheeseType")));
				
				Map<Ingred,Float> calorieTable = new HashMap<Ingred,Float>();
				calorieTable.put(Ingred.protein, result.getFloat("protein"));
				calorieTable.put(Ingred.vitamin, result.getFloat("vitaminB1"));
				calorieTable.put(Ingred.fat, result.getFloat("fat"));
				
				cheese.setCalorieTable(calorieTable);
				
				list.add(cheese);
			}
			
			stmt = dbcon.createStatement();
			query = "select * from milk_tbl";
			result = stmt.executeQuery(query);
			while(result.next())
			{
				Milk milk = new Milk();
				milk.setId(result.getInt("id"));
				milk.setDescription(result.getString("description"));
				milk.setWeight(result.getFloat("weight"));
				milk.setPrice(result.getFloat("price"));
				milk.setManufacturingDate(result.getDate("mfg_date"));
				milk.setUseBeforeMonths(result.getInt("useBeforeInMonths"));
				milk.setMilkpacket(MilkType.valueOf(result.getString("milkType")));
				
				milk.setFatRate(result.getFloat("fatRate"));
				
				list.add(milk);
				
			}
			
			stmt = dbcon.createStatement();
			query = "select * from wheat_tbl";
			result = stmt.executeQuery(query);
			while(result.next())
			{
				Wheat wheat = new Wheat();
				wheat.setId(result.getInt("id"));
				wheat.setDescription(result.getString("description"));
				wheat.setWeight(result.getFloat("weight"));
				wheat.setPrice(result.getFloat("price"));
				wheat.setManufacturingDate(result.getDate("mfg_date"));
				wheat.setUseBeforeMonths(result.getInt("useBeforeInMonths"));
				wheat.setWheatType(WheatType.valueOf(result.getString("wheatType")));
				
				list.add(wheat);
			}
			dbcm.closeConnection();
		}
		catch(SQLException e)
		{
			System.out.println("SQLException occured!!");
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Class not found!!");
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void calculateExpiryDate(List<Item> items) 
	{
		//SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		for(Item item : items)
		{
			Date mfgDate = item.getManufacturingDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(mfgDate);
			cal.add(Calendar.MONTH, item.getUseBeforeMonths());
			item.setExpiryDate(cal.getTime());
		}
	}

	@Override
	public void removeExpiredItems(List<Item> items) 
	{
		Iterator<Item> it = items.iterator();
		while(it.hasNext())
		//for(Item item : items)
		{
			Item item= it.next();
			Calendar today = Calendar.getInstance();
			Calendar expDate = Calendar.getInstance();
			expDate.setTime(item.getExpiryDate());
			if(today.after(expDate))
			{
				//items.remove(item);
				it.remove();
			}
		}
	}

	@Override
	public void sortItems(List<Item> items) 
	{
		Collections.sort(items, new Comparator() 
		{

	        public int compare(Object o1, Object o2) 
	        {

	            Date x1 = ((Item) o1).getExpiryDate();
	            Date x2 = ((Item) o2).getExpiryDate();
	            return x2.compareTo(x1);
	            
	        }   
	    });
	}

	@Override
	public void applyDiscount(List<Item> items) 
	{
		Calendar today = Calendar.getInstance();
		today.add(Calendar.MONTH, 6);
		for(Item item : items)
		{
			Calendar expDate = Calendar.getInstance();
			expDate.setTime(item.getExpiryDate());
			if(today.after(expDate))
			{
				float price = item.getPrice();
				price *= 0.80;
				item.setPrice(price);
			}
			
		}
	}

	@Override
	public List<Item> searchItem(String ItemType, List<Item> list)
			throws NoDataFoundException 
	{
		List<Item> found = new ArrayList<Item>();
		
		for(Item item : list)
		{
			String arr[] = item.getDescription().split(" ");
			for(String s : arr)
			{
				if(s.toLowerCase().equals(ItemType.toLowerCase()))
				{
					found.add(item);
				}
			}
		}
		
		if(found.isEmpty())
		{
			throw new NoDataFoundException();
		}
		else
		{
			return found;
		}
	}
		
}
