package gov.in.oupp.training.java.corejavatraining.atmmachine2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
	
	public static Connection getcon() throws SQLException,Exception{
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Connection con =DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ouppdb?useSSL=false",
				"root","system");
				return con;
	}
}
