package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.example.model.CountObject.number_object;


public class GetAreaDataFromDB {
	ConnectionManager connectionManager;

	Connection connection;

	public GetAreaDataFromDB() {

		connectionManager = new ConnectionManager();
		connectionManager.openConnection();
		connection = connectionManager.connection;

		System.out.println("connectionManager");
	}

	public ArrayList<SimpleParkingDataObject> getAreaDB(String area) {
		ArrayList<SimpleParkingDataObject> simpleArray = new ArrayList<SimpleParkingDataObject>();
		
		try {
		
			String findString = "SELECT originalId, taiwanCity, taiwanArea, name, fee, TYPE , totalCar, totalMotor FROM  `simple_parking_data` WHERE TaiwanCity = '新北市' AND TaiwanArea = ?";

			PreparedStatement preparedStmtFindTheArea = connection.prepareStatement(findString);
			preparedStmtFindTheArea.setString(1,area );
			ResultSet resTheArea = preparedStmtFindTheArea.executeQuery();
			
			while (resTheArea.next()) {
				
				SimpleParkingDataObject theObj=new SimpleParkingDataObject(resTheArea.getString(1), resTheArea.getString(2),resTheArea.getString(3),resTheArea.getString(4),Integer.valueOf(resTheArea.getString(5)),resTheArea.getString(6),Integer.valueOf(resTheArea.getString(7)),Integer.valueOf(resTheArea.getString(8)));
				simpleArray.add(theObj);
			}
			
			resTheArea.close();

			return simpleArray;
		} catch (SQLException e) {
			System.out.println("錯誤:");
			System.out.println(e.getMessage());
			return simpleArray;
		}
	}
}