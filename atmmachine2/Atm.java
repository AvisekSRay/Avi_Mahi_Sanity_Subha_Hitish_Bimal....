package gov.in.oupp.training.java.corejavatraining.atmmachine2;

import java.util.Scanner;

public class Atm {
	
	public static void main(String[] args) throws Exception {
		Customer customer = new Customer();
		Userauthentication login = new Userauthentication();
		Transaction transaction = new Transaction();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("Select 1 to Register and 2 to Login");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			//Signup
			customer.customerDetails();
			break;
		case 2:
			//Login
			login.login();
			transaction.transaction();
			break;
		default:
			System.out.println("Enter a valid choice");
		}
	}
	
}
