package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Override and implement all the methods of DBConnectionUtil Interface in this class 
public class DatabaseConnectionManager implements DBConnectionUtil 
{
	Connection dbcon;
	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException 
	{
		// TODO Auto-generated method stub
		dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb","root","root");
		return dbcon;
	}

	@Override
	public void closeConnection() throws SQLException 
	{
		// TODO Auto-generated method stub
		dbcon.close();
	}		
		
}
