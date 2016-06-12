package com.example.model;

public class CountObject {
	private String taiwanArea;
	
	private int low;
	
	private int mid;
	
	private int high;
	
	public CountObject(String taiwanArea, int low, int mid, int high) {
		setTaiwanArea(taiwanArea);
		setLow(low);
		setMid(mid);
		setHigh(high);
	}
	
	public String getTaiwanArea(String taiwanArea) {
		return this.taiwanArea;
	}

	public void setTaiwanArea(String taiwanArea) {
		this.taiwanArea = taiwanArea;
	}
	
	public int getLow(int low) {
		return this.low;
	}

	public void setLow(int low) {
		this.low = low;
	}
	
	public int getMid(int mid) {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public int getHigh(int high) {
		return this.high;
	}

	public void setHigh(int high) {
		this.high = high;
	}
}
