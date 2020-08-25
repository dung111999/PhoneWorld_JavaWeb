package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	
	public Connection getJDBCConnection() {
		final String username = "root";
		final String password = "";
		final String url = "jdbc:mysql://localhost:3306/phoneworld";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		Connection conn = getJDBCConnection();
//		if(conn != null) {
//			System.out.println("Successfully");
//		} else {
//			System.out.println("Failed");
//		}
//	}

}
