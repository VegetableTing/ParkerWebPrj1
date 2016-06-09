package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {
	
	static Connection connection;
	
	public ConnectionManager(){
		 connection = null;
	}
	
	public static void openConnection()	
	{
		System.out.println("-------- MySQL JDBC Connection ------------");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found !!");
		    return;
		}
		   System.out.println("MySQL JDBC Driver Registered!");
		  
		try 
		{
		   connection = DriverManager //jdbc:mysql://localhost:3306/data
		    		.getConnection("jdbc:mysql://188.166.177.111:3306/parker?useUnicode=true&characterEncoding=UTF-8", "parker", "00257112");
		    System.out.println("SQL Connection to database established!");
		         
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			System.out.println(e.getMessage());
			return;
		} 
	
	}
	
	
	
	public static void inserToDB(SimpleParkingFeeObject object){
		
		try{
			String query = " insert into simple_parking_fee ( taiwanCity, taiwanArea, name,fee)"
					+ " values (?,?,?,?)";
	 
			PreparedStatement preparedStmt = connection.prepareStatement(query);
	  
		    preparedStmt.setString (1, object.getTaiwanCity());
		    preparedStmt.setString (2, object.getTaiwanArea());
		    preparedStmt.setString (3, object.getName());
		    preparedStmt.setInt (4, object.getFee());
		  	 
		    // execute the preparedstatement
		    preparedStmt.execute();
		    System.out.println("插入完成");
	         
	     } catch (SQLException e) {
	    	 System.out.println("InsertToDB插入失敗");
	    	 System.out.println(e.getMessage());
	         return;
	     } 
	}
	
	
	public static void closeConnection(){
		
		try{
	    	if(connection != null)connection.close();
	    	System.out.println("Connection closed !!");
	    } catch (SQLException e) {
	         e.printStackTrace();
	    }
		
		
	}
	

}