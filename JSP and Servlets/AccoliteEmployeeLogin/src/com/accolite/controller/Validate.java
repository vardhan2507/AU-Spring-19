package com.accolite.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public static boolean checkUser(Connection con,String username,String pass) 
    {
     boolean st =false;
     try{

	 
        PreparedStatement ps =con.prepareStatement("select * from users where username=? and password=?");
        
        ps.setString(1, username);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
       
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
}
