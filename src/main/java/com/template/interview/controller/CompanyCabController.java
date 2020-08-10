package com.template.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.interview.model.Rating;
import com.template.interview.service.CompanyCabService;

//Required imports
@RestController
@RequestMapping("/cab")
public class CompanyCabController {
	@Autowired
	CompanyCabService companyCabService;

	@PostMapping(value = "/rateATrip")
	public void rateATrip(@RequestBody Rating rating) {
		companyCabService.rateATrip(rating);
	}

	@GetMapping(value = "/findRide/{name}")
	public String findRide(@PathVariable("name") String name) {
		return companyCabService.findRide(name);
	}

}