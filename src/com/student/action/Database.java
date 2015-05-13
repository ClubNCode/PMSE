package com.student.action;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

import com.student.Db.ConnectionFactory;

public class Database {
	Statement st;
	ResultSet rs;
	Connection conn;

	

	  public Connection getConnection()throws ClassNotFoundException {
		Connection con=null;
		try{
			con=ConnectionFactory.getConnection();
		}catch(Exception e){
			
		}
		return con;
		} 

	
}
