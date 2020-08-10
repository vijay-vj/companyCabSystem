package com.template.interview.repository;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.template.interview.InterviewApplication;
import com.template.interview.model.Rating;

public class CompanyCabRepository {
	private InterviewApplication inApp = new InterviewApplication();

	

	public double getAvgRating(String name, String type) {
		double rating = 0.0;
		double avgRating = 0.0;
		try {

			if (type.equals("D")) {
				List<Rating> userRating = inApp.ratings.stream().filter(ratings -> ratings.getCabDriver().equals(name))
						.collect(Collectors.toList());

				for (int i = 0; i < userRating.size(); i++) {
					rating = rating + userRating.get(i).getCabDriverRating();
				}
				avgRating = Math.round(rating / userRating.size());
			} else {
				List<Rating> userRating = inApp.ratings.stream().filter(ratings -> ratings.getCabTaker().equals(name))
						.collect(Collectors.toList());

				for (int i = 0; i < userRating.size(); i++) {
					rating = rating + userRating.get(i).getCabTakerRating();
				}
				avgRating = Math.round(rating / userRating.size());
			}

		} catch (Exception e) {

		}
		return avgRating;

	}

	public String getEligibleDriver(String name, double avgRating) {
		// Get drivers whose avg > user avg
		String currDriver = "";
		double currDriverScore = 0.0;
		try {

			for (Entry<String, Double> driver : inApp.drivers.entrySet()) {
				if (driver.getValue() >= avgRating) {

					// check Past ratings:
					if (!hasBadRepo(name, driver.getKey())) {
						// validCabDrivers.put(driver.getKey(), driver.getValue());
						if (driver.getValue() > currDriverScore) {
							currDriver = driver.getKey();
							currDriverScore = driver.getValue();
						}
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return currDriver;
		// in those drivers, check past trips for < 1 rating and eliminate those users.

	}

	public boolean hasBadRepo(String taker, String driver) {
		boolean hasBadRepo = false;
		List<Rating> userRating = inApp.ratings.stream()
				.filter(ratings -> ratings.getCabTaker().equals(taker) && ratings.getCabDriver().equals(driver))
				.collect(Collectors.toList());
		for (int i = 0; i < userRating.size(); i++) {
			if (userRating.get(i).getCabDriverRating() <= 1 || userRating.get(i).getCabTakerRating() <= 1) {
				hasBadRepo = true;
			}
		}
		return hasBadRepo;
	}

	public String getDriverWithMaxScore() {
		String currDriver = "";
		double currDriverScore = 0.0;
		for (Entry<String, Double> driver : inApp.drivers.entrySet()) {
			if (driver.getValue() > currDriverScore) {
				currDriver = driver.getKey();
				currDriverScore = driver.getValue();
			}
		}
		return currDriver;
	}
}
