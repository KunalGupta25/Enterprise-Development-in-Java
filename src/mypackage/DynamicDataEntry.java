package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicDataEntry {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "k4912005";
		
		Scanner data = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established! ");
			
			System.out.println("Add Your Data:");
			System.out.println("Enter ID: ");
			int input_id = data.nextInt();
			data.nextLine();
			System.out.println("Enter Name: ");
			String input_name = data.nextLine();
			System.out.println("Enter Salary: ");
			int input_salary = data.nextInt();
			
			Statement stmt = con.createStatement();
			// dynamically add data into table using prepared Statement
			String query = "insert into ct (id, name, salary) value (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, input_id);
			pstmt.setString(2, input_name);
			pstmt.setInt(3, input_salary);
			pstmt.executeUpdate();
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
			data.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
