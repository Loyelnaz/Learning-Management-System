package com.src.database;

import java.sql.*;

public class DBConnector {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/lms";
		
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
		
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}	
}

