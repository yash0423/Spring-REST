package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;

@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public String sayHello()  
	{  
	logger.info("START");
	return "Hello World !!"; 
	
	}  
	
}
