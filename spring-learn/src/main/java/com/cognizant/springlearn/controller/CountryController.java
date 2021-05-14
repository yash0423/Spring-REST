package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.service.CountryService;
import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
//@RequestMapping("/countries")
public class CountryController {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	
	@Autowired
	private CountryService countryService;
	
	//Returns the details of Country India 
		@RequestMapping(value = "/country", method = RequestMethod.GET)
		public Country getCountryIndia() {
			logger.info("Start");
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
			Country india = (Country) context.getBean("in");
			logger.info("End");
			return india;
		}
		
		//Return the list of countries
		@GetMapping("/countries")
		public List<Country> getAllCountries() {
			logger.info("Start");
			logger.info("End");
			return CountryService.getAllCountries();
		}
		
		@GetMapping(value = "/countries/{code}")
		public Country getCountryByCode(@PathVariable("code") String code) throws CountryNotFoundException {
			logger.info("Start");
			logger.info("End");
			return CountryService.findCountryById(code);
		}
		
		@PutMapping("/countries/{code}")
		public void updateCountry(@PathVariable("code") String code, @RequestBody @Valid Country country) throws CountryNotFoundException{
			logger.info("Start");
			logger.info("End");
			countryService.updateCountry(code, country);
		}
		
		@DeleteMapping("/countries/{code}")
		public ArrayList<Country> deleteCountry(@PathVariable("code") String code) throws CountryNotFoundException{
			logger.info("Start");
			logger.info("End");
			return countryService.deleteCountry(code);
		}
		
		@PostMapping()
		public Country addCountry(@RequestBody @Valid Country country) {
			logger.info("Started the POST request");
			logger.debug("Country details: " + country);		
			logger.info("End!!");
			
			// Create validator factory

			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

			Validator validator = factory.getValidator();

			// Validation is done against the annotations defined in country bean

			Set<ConstraintViolation<Country>> violations = validator.validate(country);

			List<String> errors = new ArrayList<String>();

			// Accumulate all errors in an ArrayList of type String

			for (ConstraintViolation<Country> violation : violations) {

			errors.add(violation.getMessage());

			}

			// Throw exception so that the user of this web service receives appropriate error message

			if (violations.size() > 0) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

			}
			return country;
		}
}
