package mysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysql 
{


	public void menuList() 
	{
		System.out.println("\nSelect an Option");
		System.out.println("1... List All");
		System.out.println("2... Insert");
		System.out.println("3... Update");
		System.out.println("4... Delete");
		System.out.println("5... Search");
		System.out.println("6... Exit");
		System.out.print("Enter your choice...");
	}

	public void listAll() 
	{
		Connection dbcon;
		try 
		{
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost/codejava", "root", "root");
			Statement stmt = dbcon.createStatement();
			String query = "Select * from userlist";
			ResultSet rslt = stmt.executeQuery(query);
			while (rslt.next()) 
			{
				System.out.println(rslt.getInt("id") + "\t" + rslt.getString("name"));
			}
			dbcon.close();
		}
		catch (Exception ex) 
		{
			System.out.print(ex);
		}
	}

	public void insert() 
	{
		Connection dbcon;
		try 
		{
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost/codejava", "root", "root");
			PreparedStatement stmt = dbcon.prepareStatement("Insert into userlist(name) values(?)");
		
			System.out.println("Enter a new name to insert");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String data = br.readLine();
			stmt.setString(1, data);
			if (stmt.executeUpdate() > 0) 
			{
				System.out.println("Successfully inserted the data");
			}
			dbcon.close();
		}
		catch (Exception ex)
		{
			System.out.print(ex);
		}
	}

	public void update() 
	{
		Connection dbcon;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost/codejava", "root", "root");
			PreparedStatement stmt = dbcon.prepareStatement("Update userlist set name=? where id = ?");
			System.out.println("Please enter the record number to modify");
			int row = Integer.parseInt(br.readLine());
			stmt.setInt(2, row);
			System.out.println("Enter the new data");
			String data = br.readLine();
			stmt.setString(1, data);
			if (stmt.executeUpdate() > 0) 
			{
				System.out.println("Updated the record");
			}
			else 
			{
				System.out.println("Record not found");
			}
			dbcon.close();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}

	public void delete()
	{
		Connection dbcon;
		try {
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost/codejava", "root", "root");
			Statement stmt = dbcon.createStatement();
			System.out.println("Enter the record to be deleted");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String row = br.readLine();
			if (stmt.executeUpdate("delete from userlist where id = " + row) > 0) {
			System.out.println("Row Deleted");
			} else {
			System.out.println("Row not found");
			}
			dbcon.close();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}

	public void search() 
	{
		Connection dbcon;
		try
		{
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost/codejava", "root", "root");
			Statement stmt = dbcon.createStatement();
			System.out.println("Enter the name to Search");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String key = br.readLine();
			ResultSet rslt = stmt.executeQuery("Select * from userlist where name like '%" + key + "%'");
			while (rslt.next())
			{
				System.out.println(rslt.getInt("id") + "\t" + rslt.getString("name"));
			}
			dbcon.close();
		}
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
	}

	public void processInput(int i)
	{
		switch (i)
		{
			case 1:
				listAll();
				break;
			case 2:
				insert();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				search();
				break;
			case 6:
				System.out.println("Thanks for using Curd Demo by http://codejava.in");
				System.exit(0);
			default:
				System.out.println("Please retry");
		}

	}

	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} 
		catch (Exception ex) 
		{
				System.out.println("Error loading driver :" + ex.toString());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;
		do 
		{
			mysql curdobj = new mysql();
			curdobj.menuList();
			try
			{
				option = Integer.parseInt(br.readLine());
				System.out.println("\n");
				curdobj.processInput(option);
			}
			catch (IOException ex) 
			{
				System.out.print(ex);
			}
		} while (option != 6);
	}
}