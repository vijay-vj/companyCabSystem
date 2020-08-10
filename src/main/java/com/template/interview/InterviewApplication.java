package com.template.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.template.interview.model.CabDriver;
import com.template.interview.model.CabTaker;
import com.template.interview.model.Rating;
import com.template.interview.service.impl.CompanyCabServiceImpl;

@SpringBootApplication
public class InterviewApplication {
	private static CompanyCabServiceImpl ccService = new CompanyCabServiceImpl();
	public static HashMap<String , Double> takers = new HashMap<String, Double>();
	public static HashMap<String , Double> drivers = new HashMap<String , Double>();
	public static List<Rating> ratings = new ArrayList<Rating>();
	
	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);

		// Adding History Data
		CabTaker taker1 = new CabTaker("Ram", 0.0);
		CabTaker taker2 = new CabTaker("Lakshman", 0.0);
		CabTaker taker3 = new CabTaker("Bharat", 0.0);
		takers.put(taker1.getName(),taker1.getAvgRating());
		takers.put(taker2.getName(),taker2.getAvgRating());
		takers.put(taker3.getName(),taker3.getAvgRating());
		
		CabDriver driver1 = new CabDriver("Bheem", 0.0);
		CabDriver driver2 = new CabDriver("Nakul", 0.0);
		CabDriver driver3 = new CabDriver("Sahdev", 0.0);
		drivers.put(driver1.getName(),driver1.getAvgRating());
		drivers.put(driver2.getName(),driver2.getAvgRating());
		drivers.put(driver3.getName(),driver3.getAvgRating());
				
		Rating a = new Rating("Ram", 3.0, "Bheem", 5.0);
		Rating b = new Rating("Lakshman", 5.0, "Nakul", 2.0);
		Rating c = new Rating("Ram", 4.0, "Sahdev", 2.0);
		Rating d = new Rating("Bharat", 3.0, "Bheem", 1.0);
		Rating e = new Rating("Ram", 3.0, "Bheem", 5.0);
		Rating f = new Rating("Lakshman", 5.0, "Sahdev", 5.0);
		Rating g = new Rating("Bharat", 5.0, "Nakul", 5.0);

		ccService.rateATrip(a);
		ccService.rateATrip(b);
		ccService.rateATrip(c);
		ccService.rateATrip(d);
		ccService.rateATrip(e);
		ccService.rateATrip(f);
		ccService.rateATrip(g);
					
	}

}
