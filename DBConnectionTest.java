package gov.in.oupp.training.java.corejavatraining.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionTest {

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/ouppdb?useSSL=false";
		String userName="root";
		String password="system";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.
			getConnection(url,userName,password);
			System.out.println("Connection Established");
			PreparedStatement ps=con.
			prepareStatement("delete from student where id = ?;");
			
			ps.setInt(1, 105);

			int records=ps.executeUpdate();
		    System.out.println("Record Inserted: "+records);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from student");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+
				" "+rs.getInt(3)+" "+rs.getString(4));
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
