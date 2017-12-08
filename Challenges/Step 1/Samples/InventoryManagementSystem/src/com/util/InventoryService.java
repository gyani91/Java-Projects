package com.util;

import java.util.List;

import com.bean.Item;
import com.exception.NoDataFoundException;

public interface InventoryService {
	// Reading Data from database and store into List
	// Read data from milk_tbl,cheese_tbl and Wheat table and store into Item List
	List<Item> readAllItemsFromDb();
	
	// Calulate Expiry date for Item using Manufacturing date and useBeforeInMonths int value (which shows use before no of months.) 
	void calculateExpiryDate(List<Item> items);
	
	//Compare ItemExpiry date with today's date and remove Item if it is Expired. 
	void removeExpiredItems(List<Item> items);
	
	//Sort Items In Descending  order 
	void sortItems(List<Item> items);
	
	//apply 20% discount on Items to be expired in next six months 
	void applyDiscount(List<Item> items);
	
	// Search Item in table use description property to search Item. 
	List<Item>searchItem(String ItemType,List<Item> list)throws NoDataFoundException;
	
	

}
