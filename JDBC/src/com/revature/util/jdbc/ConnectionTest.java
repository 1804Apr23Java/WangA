package com.revature.util.jdbc;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);		
	}
}
