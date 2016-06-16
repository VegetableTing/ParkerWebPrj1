package com.example.model;

import java.sql.*;
import java.text.NumberFormat;
import java.util.*;

public class getChartFromDB {
	ConnectionManager connectionManager;

	Connection connection;

	public getChartFromDB() {

		connectionManager = new ConnectionManager();
		connectionManager.openConnection();
		connection = connectionManager.connection;

		System.out.println("connectionManager");
	}

	public ArrayList<PieChartObject> getChartDB() {
		ArrayList<PieChartObject> arr = new ArrayList<PieChartObject>();
		try {

			String _dynamic = "SELECT type_dynamic FROM `simple_parking_type` WHERE 1";
			String _static = "SELECT type_static FROM `simple_parking_type` WHERE 1";

			PreparedStatement statement_dynamic = connection.prepareStatement(_dynamic);
			PreparedStatement statement_static = connection.prepareStatement(_static);

			double dynamic_amount = 0, static_amount = 0;
			ResultSet dynamic_result = statement_dynamic.executeQuery();
			ResultSet static_result = statement_static.executeQuery();

			while (dynamic_result.next()) {
				dynamic_amount += Integer.valueOf(dynamic_result.getString(1));
			}

			while (static_result.next()) {
				static_amount += Integer.valueOf(static_result.getString(1));
			}

			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(1);//Decimal 1 point		

			arr.add(new PieChartObject("red", "動態停車場", "動態停車場",
					Double.parseDouble(nf.format((dynamic_amount / (dynamic_amount + static_amount))))));
			arr.add(new PieChartObject("blue", "靜態停車場", "靜態停車場",
					Double.parseDouble(nf.format((static_amount / (dynamic_amount + static_amount))))));

			return arr;
		} catch (SQLException e) {
			System.out.println("");
			System.out.println(e.getMessage());
			return arr;
		}
	}
}
