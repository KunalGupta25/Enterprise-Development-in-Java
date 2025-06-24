package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "k4912005";
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection(url, username, password);

			System.out.println("Enter Id you want Update: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter new Salary: ");
			int salary = sc.nextInt();

			String updateSQL = "update ct SET salary = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(updateSQL);
			pstmt.setInt(1, salary);
			pstmt.setInt(2,  id);

			System.out.println("data Updated Successfully");


			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}