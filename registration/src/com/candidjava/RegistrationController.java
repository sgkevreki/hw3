package com.candidjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fullname");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String age = request.getParameter("age");
		
		
		// validate given input
		if(name.isEmpty()||age.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			// inserting data into mysql database
			// create a test database and student table before running this
			try {
				Class.forName("com.mysql.jdbc.Driver");
			// loads mysql driver
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "gkevre!"); // connection with test database
			
			String query="insert into student values(?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);  // generates sql query
			
			ps.setString(1, name);
			ps.setString(2, userName);
			ps.setString(3, pass);
			ps.setInt(5, Integer.parseInt(age));
		
			
			ps.executeUpdate(); // execute it on test database
			System.out.println("successfuly inserted");
			ps.close();
			con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
	}
}
