package com.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Administrator
 *
 */
public class DatabaseConnectionManager implements DBConnectionUtil {	
	
	Connection conn;
	
	public DatabaseConnectionManager() { /*does nothing*/ }	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb","root","root");
		
		
		if(!conn.isClosed())
			System.out.println("Connection successfull..!!!!");
		
		return conn;
		
	}
	public void closeConnection() throws SQLException
	{
		conn.close();
	}
	
}
