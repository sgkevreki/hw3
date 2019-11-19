package com.reglog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

				response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        
        Connection c = null;
		Statement stmt = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
	        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC","root","gkevre!");
	        System.out.println("Opened database successfully");
	        
	        stmt = c.createStatement();
	        String sql = "SELECT max(ID) FROM users";
	        ResultSet rs = stmt.executeQuery(sql);
	        rs.next();
	        Integer maxid = rs.getInt("max(ID)");
	        stmt = c.createStatement();
	        sql = "select count(*)" + 
	        		"from users U " + 
	        		"where '"+userid+"' in (select userid from users US where U.id=US.ID)";
	        rs = stmt.executeQuery(sql);
	        rs.next();
	        Integer validnum = rs.getInt("count(*)");
	        if (validnum==0){
	            PreparedStatement ps = c.prepareStatement
	                        ("INSERT INTO users( id, name, userid, password) values(?,?,?,?)");
	            ps.setInt(1, maxid+1);
	            ps.setString(2, name);
	            ps.setString(3, userid);
	            ps.setString(4, password);
	            
	            int i = ps.executeUpdate();
	            
	            if(i > 0) {
	                System.out.println("You are sucessfully registered");
	                response.sendRedirect("index.html");
	            }
	        }
	        else {
	        	out.println("This password already exists!");
	        	RequestDispatcher ns = request.getRequestDispatcher("register.html");
	            ns.include(request, response);
	        }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
}