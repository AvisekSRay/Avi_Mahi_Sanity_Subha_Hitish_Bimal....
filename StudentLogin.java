package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentLogin {
	public static boolean login()
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ouppdb","root","5518");
			PreparedStatement ps=con.prepareStatement("select * from studentdb where ID=? and password=?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your ID ");
			String ID=sc.next();
			System.out.println("Enter password");
			String password=sc.next();
			ps.setString(1, ID);
			ps.setString(2, password);
			try (ResultSet resultSet = ps.executeQuery()) {
                return resultSet.next() ? true : false;
            }
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
}
