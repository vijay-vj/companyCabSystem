package com.template.interview.model;

public class Employee {
	private String name;
	private double avgRating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public Employee(String name, double avgRating) {
		super();
		this.name = name;
		this.avgRating = avgRating;
	}

	public Employee() {

	}

}
