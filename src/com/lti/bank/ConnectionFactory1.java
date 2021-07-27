package com.lti.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory1 {

	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "hr";
	private static final String PASS = "hr";
	private static Connection connection=null;
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	public static void main(String[] args) {
		if(getConnection()!=null)
			System.out.println("connected");
		else
			System.out.println("not connected");
	}
}
