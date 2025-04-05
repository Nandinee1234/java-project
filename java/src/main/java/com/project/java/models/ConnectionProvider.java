package com.project.java.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
static private Connection connection=null;
	
	public static Connection getConnection()
	{
		 String url="jdbc:mysql://localhost:3306/library";
		try {
			if(connection==null)
			   connection=DriverManager.getConnection(url, "root", "Root");
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}

}


