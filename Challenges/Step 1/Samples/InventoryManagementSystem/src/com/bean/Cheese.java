package com.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cheese extends Item {
	public CheeseType cheeseType ;
	public Map<Ingred,Float> calorieTable = new HashMap<Ingred,Float>();
	
	
	public Cheese() {
	}
	
	public Cheese(int id, String description, float weight, float price,
			Date manufacturingDate, int useBeforeMonths, CheeseType cheeseType,
			float protein,float vitamin,float fat) {
		super(id, description, weight, price, manufacturingDate,
				useBeforeMonths);
		this.cheeseType = cheeseType;
		this.calorieTable.put(Ingred.protein, protein);
		calorieTable.put(Ingred.vitamin, vitamin);
		calorieTable.put(Ingred.fat, fat);
	}

	

	public CheeseType getCheeseType() {
		return cheeseType;
	}

	public void setCheeseType(CheeseType cheeseType) {
		this.cheeseType = cheeseType;
	}

	public Map<Ingred, Float> getCalorieTable() {
		return calorieTable;
	}

	public void setCalorieTable(Map<Ingred, Float> calorieTable) {
		this.calorieTable = calorieTable;
	}
	
	@Override
	public String toString() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	
		return this.getId()
		+ " "
		+ this.getDescription()
		+ " "
		+ formatter.format(this.getManufacturingDate())
		+ " "
		+ (getExpiryDate()!=null? formatter.format(this.getExpiryDate()):" ")		
		+ " "
		+ this.getPrice();	
	}
	
	
}
