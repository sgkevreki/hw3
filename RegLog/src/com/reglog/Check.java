package com.reglog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Check {
    public static boolean checkUser(String userid,String password) 
    {
        boolean st =false;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC","root","gkevre!");
            PreparedStatement ps = con.prepareStatement("select * from users where userid=? and password=?");
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
