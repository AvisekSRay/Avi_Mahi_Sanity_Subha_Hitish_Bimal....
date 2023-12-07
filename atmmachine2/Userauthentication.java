package gov.in.oupp.training.java.corejavatraining.atmmachine2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Userauthentication {

	public static int count=0;
	public static int card_num;
	public  static void login()throws Exception{
		Scanner sc = new Scanner(System.in);
		
		//Bulid Connection
		Connection con = BDConnection.getcon();
		
		System.out.println("Enter Your Card Number :");
		int card_number=sc.nextInt();
		System.out.println("Enter your Pin :");
		int pin=sc.nextInt();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from login");
		while(rs.next()){
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+
			//" "+rs.getInt(3)+" "+rs.getString(4));
			if(card_number==rs.getInt(1) && pin==rs.getInt(2)){
				card_num=rs.getInt(1);
				count++;
				break;
			}
		}
		sc.close();
	}
	
	
}
