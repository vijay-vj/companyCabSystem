package com.template.interview.model;

public class Rating {
	private String cabDriver;
	private String cabTaker;
	private double cabDriverRating;
	private double cabTakerRating;

	public Rating(String cabTaker, double cabTakerRating, String cabDriver, double cabDriverRating) {
		super();
		this.cabDriver = cabDriver;
		this.cabTaker = cabTaker;
		this.cabDriverRating = cabDriverRating;
		this.cabTakerRating = cabTakerRating;
	}

	public String getCabDriver() {
		return cabDriver;
	}

	public void setCabDriver(String cabDriver) {
		this.cabDriver = cabDriver;
	}

	public String getCabTaker() {
		return cabTaker;
	}

	public void setCabTaker(String cabTaker) {
		this.cabTaker = cabTaker;
	}

	public double getCabDriverRating() {
		return cabDriverRating;
	}

	public void setCabDriverRating(double cabDriverRating) {
		this.cabDriverRating = cabDriverRating;
	}

	public double getCabTakerRating() {
		return cabTakerRating;
	}

	public void setCabTakerRating(double cabTakerRating) {
		this.cabTakerRating = cabTakerRating;
	}

}
