package com.util;

import java.util.Comparator;

import com.bean.Item;


public class SortItem implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {		
		return item2.getExpiryDate().compareTo(item1.getExpiryDate());
	}

}
