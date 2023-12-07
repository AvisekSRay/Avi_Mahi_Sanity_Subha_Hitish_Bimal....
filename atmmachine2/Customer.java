package gov.in.oupp.training.java.corejavatraining.atmmachine2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class Customer {

	int customer_Id;
	String customer_name;
	String customer_address;
	int contact_number;
	
	public static void customerDetails() throws Exception{
		
	int c_id;
	String c_name;
	String c_address;
	int c_number;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter Your User ID");
	c_id = sc.nextInt();
	System.out.println("Enter Your User Name");
	c_name = sc.nextLine();
	System.out.println("Enter Your User Address");
	c_address = sc.nextLine();
	System.out.println("Enter your Contact number");
	c_number = sc.nextInt();
	
	Connection con = BDConnection.getcon();
	PreparedStatement ps=con.
	prepareStatement("insert into customer values(?,?,?,?);");
	
	ps.setInt(1,c_id);
	ps.setString(2,c_name);
	ps.setString(3,c_address);
	ps.setInt(4,c_number);
	
	int records=ps.executeUpdate();
	System.out.println("Sucessfully Registered :"+records);
	
	sc.close();
	}
}
