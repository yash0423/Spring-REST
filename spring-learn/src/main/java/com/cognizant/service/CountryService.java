package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	static ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	@SuppressWarnings("unchecked")
	static ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
	
	
	public static List<Country> getAllCountries(){
		return countryList;
	}
	
	public static Country findCountryById(String code) throws CountryNotFoundException{
		for(Country country: countryList) {
			if(country.getCode().equalsIgnoreCase(code)) {
				return country;
			}
		}
		throw new CountryNotFoundException("Country with " + code + " not found!!!");

	}
	
	public void updateCountry(String code, @Valid Country countries) throws CountryNotFoundException {
		for(Country country: countryList) {
			if(country.getCode() == code) {
				country.setCode(country.getCode());
				country.setName(country.getName());
				
				return;
			}
		}
		throw new CountryNotFoundException("Country with " + code + " not found!!!");
	}
	
	public ArrayList<Country> deleteCountry(String code) throws CountryNotFoundException {
		for(Country country: countryList) {
			if(code == country.getCode()) {
				countryList.removeIf(t -> t.getCode() == code);
				return countryList;
			}
		}
		throw new CountryNotFoundException("Country with " + code + " not found!!!");
	}
}