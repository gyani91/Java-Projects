package com.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Wheat extends Item {
	private WheatType wheatType;

	public Wheat(int id, String description, float weight, float price,
			Date manufacturingDate, int useBeforeMonths, WheatType wheatType) {
		super(id, description, weight, price, manufacturingDate,
				useBeforeMonths);
		this.wheatType = wheatType;
	}

	public Wheat() {
	}

	public WheatType getWheatType() {
		return wheatType;
	}

	public void setWheatType(WheatType wheatType) {
		this.wheatType = wheatType;
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
