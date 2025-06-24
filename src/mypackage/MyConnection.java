package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	public static void main(String[] args) {
	// 1. Gather data
		String url = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "k4912005";
	
	//2. Build Connection
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection eatablished");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




































