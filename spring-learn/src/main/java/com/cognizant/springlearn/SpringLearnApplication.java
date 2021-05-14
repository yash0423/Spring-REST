package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(scanBasePackages={
		"com.cognizant.springlearn", "com.cognizant.springlearn.controller","com.cognizant.springlearn.Dao","com.cognizant.service","com.cognizant.springlearn.security"})
public class SpringLearnApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void displayCountries() {
		logger.info("START");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		@SuppressWarnings("unchecked")
		ArrayList<String> list= context.getBean("countryList",ArrayList.class);
		
		logger.debug("Country : {}", list.toString());
		logger.info("END");
	}
	
	public static void displayCountry() {
		logger.info("START");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("in", Country.class);

		logger.debug("Country : {}", country.toString());
		logger.info("END");
	}
	
	public static void displayDate() throws ParseException {
		logger.info("START");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
	
		Date date=format.parse("31/12/2018"); 
		
		logger.debug("Date :{}",date.toString());
		logger.info("END");
	}
	
	public static void main(String[] args) throws ParseException {
		//logger.info("this is a info message");
	    //logger.warn("this is a warn message");
	    //logger.error("this is a error message");
	    displayDate();
	    displayCountry();
	    displayCountries();
		SpringApplication.run(SpringLearnApplication.class, args);
		
	}

}
