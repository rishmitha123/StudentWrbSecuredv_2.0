package com.codegnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String username = "root";
		String password = "root";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		con.setAutoCommit(false);
		return con;

	}
	private ConnectionHelper() {
		//defining private constructor in class so that we cannot create object for that class
	}

}
