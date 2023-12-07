package com.oupp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int k=0;
		String s1=request.getParameter("rollno");
		String s2=request.getParameter("fname");
		String s3=request.getParameter("mname");
		String s4=request.getParameter("lname");
		String s5=request.getParameter("email");
		String s6=request.getParameter("dat");
		String s7=request.getParameter("phone");
		String s8=request.getParameter("address");
		
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection
							("jdbc:mysql://localhost:3306/ouppdb", "root", "Kanha@56");
					PreparedStatement ps=con.
							prepareStatement("insert into registerstu values(?,?,?,?,?,?,?,?);");
					ps.setString(1,s1);
					ps.setString(2,s2);
					ps.setString(3,s3);
					ps.setString(4,s4);
					ps.setString(5,s5);
					ps.setString(6,s6);
					ps.setString(7,s7);
					ps.setString(8,s8);
					k=ps.executeUpdate();
					
					if(k>0){
						out.print("Registration Succesful");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
	
	}
	

}
