package com.cg.mobile.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionObjectToUseasConnection {
	static Connection con=null;
	public static Connection getConnection(){
		if(con==null){
		String driver="";
		String url="";
		String user="";
		String pwd="";
		try{
			InputStream ins=new FileInputStream("./resources/dbconfig.properties");
			Properties prop=new Properties();
			prop.load(ins);
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			pwd=prop.getProperty("password");
			user=prop.getProperty("username");
			Class.forName(driver);
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection to DB.......");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return con;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getConnection();
	}
}
