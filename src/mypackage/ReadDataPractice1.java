package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataPractice1 {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "k4912005";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established! ");
			
			Statement stmt = con.createStatement();
//			stmt.executeUpdate("insert into ct(id, name, salary) value(102, 'Kunal', 100000.80);");
			ResultSet rs = stmt.executeQuery("select * from ct");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
			
				System.out.println("id:" +id+ " name:" +name+ " Salary:"+salary);
			}
			rs.close();
			stmt.close();
			con.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
