package com.example.model;

public class PieChartObject {
	private String color;

	private String description;

	private String title;

	private double value;

	public PieChartObject(String color, String description, String title, double value) {
		setColor(color);
		setDescription(description);
		setTitle(title);
		setValue(value);
	}

	public String getColor(String color) {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription(String description) {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle(String title) {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getValue(double value) {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
