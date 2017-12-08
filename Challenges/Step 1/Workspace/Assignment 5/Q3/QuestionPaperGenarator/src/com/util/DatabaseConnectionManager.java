package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Override and implement all the methods of DBConnectionUtil here to create and close db connection 
public class DatabaseConnectionManager implements DBConnectionUtil 
{
	Connection dbcon;
	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException 
	{
		dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/questiondb","root","root");
		return dbcon;
	}

	@Override
	public void closeConnection() throws SQLException 
	{
		dbcon.close();
	}


}
