package com.pipe.iccraw.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBCon {
	private static String  url= null;
	private static String user = null;
	private static String password = null;
	public static Connection getDBCon() throws ClassNotFoundException, SQLException{
		Properties prop = new Properties();
		DBCon db=new DBCon();
		try {
			prop.load(db.getClass().getResourceAsStream("/prop.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url=prop.getProperty("url");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url,user,password);
	}
}
