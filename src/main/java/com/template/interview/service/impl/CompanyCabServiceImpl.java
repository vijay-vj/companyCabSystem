package com.template.interview.service.impl;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.template.interview.InterviewApplication;
import com.template.interview.model.Rating;
import com.template.interview.repository.CompanyCabRepository;
import com.template.interview.service.CompanyCabService;

//Required imports
@Service
public class CompanyCabServiceImpl implements CompanyCabService {
	private InterviewApplication inApp = new InterviewApplication();
	private CompanyCabRepository repo = new CompanyCabRepository();

	@Override
	public void rateATrip(Rating rating) {
		// calc the avg score and update the records

		inApp.ratings.add(rating);
		inApp.drivers.put(rating.getCabDriver(), repo.getAvgRating(rating.getCabDriver(), "D"));
		inApp.takers.put(rating.getCabTaker(), repo.getAvgRating(rating.getCabTaker(), "T"));
	}

	@Override
	public String findRide(String name) {
		// Check for the past trip ands given ratings. .remove users who are not
		// qualified (score is < 1), avgScore of taker > avgScore of driver
		Double takerRating = inApp.takers.get(name);

		String driver = repo.getEligibleDriver(name, takerRating);
		if (driver.equals("")) {
			// get the best driver with max Score . If no one is available, find the the
			// maxScore in the current drivers gets the ride
			driver = repo.getDriverWithMaxScore();
		}

		return driver;
	}

}