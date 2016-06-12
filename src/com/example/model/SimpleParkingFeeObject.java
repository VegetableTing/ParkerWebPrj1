package com.example.model;

import com.example.model.*;

public class SimpleParkingFeeObject {

	private String taiwanCity;
	private String taiwanArea;
	private String name;
	private int fee;

	public SimpleParkingFeeObject(String taiwanCity, String taiwanArea, String name, int fee) {

		setTaiwanCity(taiwanCity);
		setTaiwanArea(taiwanArea);
		setName(name);
		setFee(fee);

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
