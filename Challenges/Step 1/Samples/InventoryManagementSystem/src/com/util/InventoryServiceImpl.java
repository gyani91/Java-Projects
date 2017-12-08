package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bean.Cheese;
import com.bean.CheeseType;
import com.bean.Item;
import com.bean.Milk;
import com.bean.MilkType;
import com.bean.Wheat;
import com.bean.WheatType;
import com.exception.NoDataFoundException;

public class InventoryServiceImpl implements InventoryService {

	static Connection conn;
		
	@Override
	public List<Item> readAllItemsFromDb() {
		List<Item> shopItems = new ArrayList<Item>();
		DBConnectionUtil dcm = new DatabaseConnectionManager();
		try {
			conn = dcm.getConnection();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from cheese_tbl");
			while (rs.next()) {
				int id = rs.getInt("id");
				String description = rs.getString("description");
				float weight = rs.getFloat("weight");
				float price = rs.getFloat("price");
				Date mfgDate = rs.getDate("mfg_date");				
				System.out.println(rs.getDate("mfg_date")+ "       " + mfgDate);
				int useBeforeMonths = rs.getInt("useBeforeInMonths");
				String cheeseType = rs.getString("cheeseType");
				float protein = rs.getFloat("protein");
				float vitamin = rs.getFloat("vitaminB1");
				float fat = rs.getFloat("fat");
				Item item = new Cheese(id, description, weight, price, mfgDate,
						useBeforeMonths, CheeseType.valueOf(cheeseType),
						protein, vitamin, fat);
				shopItems.add(item);
			}

			rs = st.executeQuery("Select * from milk_tbl");
			while (rs.next()) {

				int id = rs.getInt("id");
				String description = rs.getString("description");
				float weight = rs.getFloat("weight");
				float price = rs.getFloat("price");
				Date mfgDate = rs.getDate("mfg_date");
				int useBeforeMonths = rs.getInt("useBeforeInMonths");
				float fatRate = rs.getFloat("fatRate");
				String milkType = rs.getString("milkType");

				Item item = new Milk(id, description, MilkType
						.valueOf(milkType), weight, price, mfgDate,
						useBeforeMonths, fatRate);
				shopItems.add(item);
			}

			rs = st.executeQuery("Select * from wheat_tbl");
			while (rs.next()) {

				int id = rs.getInt("id");
				String description = rs.getString("description");
				float weight = rs.getFloat("weight");
				float price = rs.getFloat("price");
				Date mfgDate = rs.getDate("mfg_date");
				int useBeforeMonths = rs.getInt("useBeforeInMonths");
				String wheatType = rs.getString("wheatType");

				Item item = new Wheat(id, description, weight, price, mfgDate,
						useBeforeMonths, WheatType.valueOf(wheatType));
				shopItems.add(item);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return shopItems;

	}
	
	@Override
	public void calculateExpiryDate(List<Item> items) {
		Iterator<Item> itr = items.iterator();
		Calendar cal = Calendar.getInstance();

		while (itr.hasNext()) {
			
			Item itm = itr.next();
			int durationInMonths = itm.getUseBeforeMonths();
			cal.setTime(itm.getManufacturingDate());
			cal.add(Calendar.MONTH, durationInMonths);
			
			itm.setExpiryDate(cal.getTime());			

		}

	}


	@Override
	public void removeExpiredItems(List<Item> items) {
		
		Iterator<Item> it = items.iterator();
		Date expiryDate=null;
		Date today=Calendar.getInstance().getTime();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		while (it.hasNext()) {
			Item itm = it.next();
			expiryDate=itm.getExpiryDate();
			if (today.after(expiryDate))
				{
				
				System.out.println(df.format(itm.getManufacturingDate()) + " " +itm.getUseBeforeMonths() + " "+  df.format(expiryDate)+" Expired.....");
				it.remove();
				}			
		}	
		
	}

	
	@Override
	public void applyDiscount(List<Item> items) {
		// Applying Discount on the Items which will expire in next six months
		Calendar cal=Calendar.getInstance();
		
		cal.add(Calendar.MONTH,	 6);
		Date sixMonthsLaterDate=cal.getTime();
				
		
		for(Item itm:items){
			System.out.println("Price" + itm.getId() + " " + itm.getPrice());
		}
		
		for(Item itm:items)
		{
			if(itm.getExpiryDate().before(sixMonthsLaterDate)){
				float discountPrice=(float) (itm.getPrice()-itm.getPrice()*0.20);
				itm.setPrice(discountPrice);
			}
		}
		
	}

	@Override
	public List<Item> searchItem(String ItemType, List<Item> list) throws NoDataFoundException {
		
		List<Item> lst=new ArrayList<Item>();
		for(Item i :list){
			if((i.getDescription().toUpperCase()).contains(ItemType.toUpperCase()))
			{
				lst.add(i);
			}
		}
		if(lst.size()==0)
			throw new NoDataFoundException();
		return lst;
	}

	@Override
	public void sortItems(List<Item> items) {
				
		Collections.sort(items,new SortItem());
				
	}

}
