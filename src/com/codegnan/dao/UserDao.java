package com.codegnan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codegnan.util.ConnectionHelper;

public class UserDao extends Dao {
	 static public boolean validate(String username,String password) throws ClassNotFoundException, SQLException {
		 boolean res=false;
		 String sql = "select * from user where "
		 +"username = '"+username
				 +"' AND password = '"+password+"'";
			Connection con = ConnectionHelper.getConnection();
			con.commit();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				res=true;
			}
			rs.close();
			
		 return res;
		 
		 
	 }

}
