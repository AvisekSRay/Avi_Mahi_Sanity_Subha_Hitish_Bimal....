package gov.in.oupp.training.java.corejavatraining.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionTest2 {

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/ouppdb";
		String userName="root";
		String password="system";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.
			getConnection(url,userName,password);
			System.out.println("Connection Established");
			PreparedStatement ps=con.
			prepareStatement("insert into student values(?,?,?,?);");
		    ps.setInt(1,110);
		    ps.setString(2, "yash");
		    ps.setInt(3, 23);
		    ps.setString(4,"KIIT");
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
