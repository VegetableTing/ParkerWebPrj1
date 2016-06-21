package com.example.model;

import com.example.model.*;

public class SimpleParkingDataObject {
	private String id;
	private String taiwanCity;
	private String taiwanArea;
	private String name;
	private int fee;
	private String type;
	private int totalCar;
	private int totalMotor;

	public SimpleParkingDataObject(String id, String taiwanCity, String taiwanArea, String name, int fee,String type, int totalCar,int totalMotor) {
		setId(id);
		setTaiwanCity(taiwanCity);
		setTaiwanArea(taiwanArea);
		setName(name);
		setFee(fee);
		setType(type);
		setTotalCar(totalCar);
		setTotalMotor(totalMotor);

	}
	
	
	public int getTotalMotor() {
		return this.totalMotor;
	}

	public void setTotalMotor(int totalMotor) {
		this.totalMotor = totalMotor;
	}
	
	
	public int getTotalCar() {
		return this.totalCar;
	}

	public void setTotalCar(int totalCar) {
		this.totalCar = totalCar;
	}

	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getTaiwanArea() {
		return this.taiwanArea;
	}

	public void setTaiwanArea(String taiwanArea) {
		this.taiwanArea = taiwanArea;
	}

	public String getTaiwanCity() {
		return this.taiwanCity;
	}

	public void setTaiwanCity(String taiwanCity) {
		this.taiwanCity = taiwanCity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return this.fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String toString() {
		return name + " - " + fee;
	}

}
