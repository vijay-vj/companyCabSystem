package com.template.interview.service;

import com.template.interview.model.Rating;

//Required imports
public interface CompanyCabService {

	void rateATrip(Rating rating);

	String findRide(String name);

}