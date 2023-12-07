package student;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the choice");
		System.out.println("1.Create new ID\n2.User Login");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			//New Registration
			NewStudent ns=new NewStudent();
			System.out.println("Enter Your Name");
			ns.setName(sc.next());
			System.out.println("Enter Your ID");
			ns.setId(sc.next());
			System.out.println("Enter Your Contact Number");
			ns.setPhonenumber(sc.next());
			System.out.println("Enter Your Address");
			ns.setAddress(sc.next());
			System.out.println("Enter Your Password");
			ns.setPassword(sc.next());
			ns.add(ns.getId(),ns.getName(),ns.getAddress(),ns.getPhonenumber(),ns.getPassword());
			break;
		case 2:
			//StudentLogin.login();
			if(StudentLogin.login())
			{
				System.out.println("Login Suceessful");
			}
			break;
		}
	}

}
