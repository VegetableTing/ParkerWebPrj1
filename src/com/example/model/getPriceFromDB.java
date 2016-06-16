package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.example.model.CountObject.number_object;

import java.util.*;

public class getPriceFromDB {
	ConnectionManager connectionManager;

	Connection connection;

	public getPriceFromDB() {

		connectionManager = new ConnectionManager();
		connectionManager.openConnection();
		connection = connectionManager.connection;

		System.out.println("connectionManager");
	}

	public ArrayList<CountObject> getPriceDB(int low, int high) {
		ArrayList<CountObject> arr = new ArrayList<CountObject>();
		try {
			ArrayList<String> temp_area = new ArrayList<String>();
			String find_area = "SELECT taiwanArea FROM `simple_parking_fee` WHERE 1";

			PreparedStatement preparedStmt_findArea = connection.prepareStatement(find_area);
			ResultSet res_Area = preparedStmt_findArea.executeQuery();
			while (res_Area.next()) {
				temp_area.add(new String(res_Area.getString(1)));
			}
			LinkedHashSet<String> set = new LinkedHashSet<String>(temp_area);
			temp_area = new ArrayList<String>(set);

			for (int i = 0; i < temp_area.size(); i++) {

				String query_low = "SELECT * FROM `simple_parking_fee` WHERE fee<=? AND taiwanArea = ? AND fee>=0";
				String query_mid = "SELECT * FROM `simple_parking_fee` WHERE fee<=? AND ?<=fee AND taiwanArea = ? AND fee>=0";
				String query_high = "SELECT * FROM `simple_parking_fee` WHERE fee>=? AND taiwanArea = ? AND fee>=0";

				PreparedStatement preparedStmt_low = connection.prepareStatement(query_low);
				preparedStmt_low.setString(1, String.valueOf(low));
				preparedStmt_low.setString(2, String.valueOf(temp_area.get(i)));

				PreparedStatement preparedStmt_mid = connection.prepareStatement(query_mid);
				preparedStmt_mid.setString(1, String.valueOf(low));
				preparedStmt_mid.setString(2, String.valueOf(high));
				preparedStmt_mid.setString(3, String.valueOf(temp_area.get(i)));

				PreparedStatement preparedStmt_high = connection.prepareStatement(query_high);
				preparedStmt_high.setString(1, String.valueOf(high));
				preparedStmt_high.setString(2, String.valueOf(temp_area.get(i)));
				///////////////////////////////////////////////////////

				ResultSet res_low = preparedStmt_low.executeQuery();
				ResultSet res_mid = preparedStmt_mid.executeQuery();
				ResultSet res_high = preparedStmt_high.executeQuery();
				int low_count = 0, mid_count = 0, high_count = 0;
				while (res_low.next()) {
					low_count++;
				}
				while (res_mid.next()) {
					mid_count++;
				}
				while (res_high.next()) {
					high_count++;
				}

				res_low.close();
				res_mid.close();
				res_high.close();
				
				number_object t=new number_object(low_count, mid_count, high_count);
					
				arr.add(new CountObject(temp_area.get(i), t));

			}
			return arr;
		} catch (SQLException e) {
			System.out.println("");
			System.out.println(e.getMessage());
			return arr;
		}
	}
}
