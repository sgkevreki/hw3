package com.reglog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        
        if(Check.checkUser(userid, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("register.html");
           rs.include(request, response);
        }
    }  
}
