package gov.in.oupp.training.java.corejavatraining.atmmachine2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Transaction {
	
	public void transaction() throws Exception{
		
		Scanner sc = new Scanner(System.in);
		Userauthentication login = new Userauthentication();
		
		if(login.count > 0){
			System.out.println("Choose");
			System.out.println("1.Withdraw");
			System.out.println("2.Deposite");
			System.out.println("3.Check Balance");
			int choice = sc.nextInt();
			switch(choice){
			case 1:
				double balance=0.0;
				//Withdraw
				Connection con = BDConnection.getcon();
				PreparedStatement ps=con.
				prepareStatement("select balance from account where account_number = ?;");
				ps.setInt(1, login.card_num);
				   
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					balance=rs.getDouble(2);
				}
				
				System.out.println("Balance = "+ balance);
				break;
			case 2:
				//Deposite
				break;
			case 3:
				//Check Balance
				break;
			default:
				System.out.println("Enter a valid Choice");
			}
		}else{
			
		}
	}
	
}
