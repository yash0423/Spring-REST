package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);
	@NotNull
	@Size(min = 2, max = 2, message = "Country code should be 2 characters")
	private String code;
	private String name;

	public Country(String code,String name){
		this.code=code;
		this.name=name;
		logger.info("Inside Country Constructor.");
		
	}
	public Country() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getCode() {
		logger.debug("Inside code getter.");
		return code;
	}
	public void setCode(String code) {
		logger.debug("Inside code setter.");
		this.code = code;
	}
	public String getName() {
		logger.debug("Inside name getter.");
		return name;
	}
	public void setName(String name) {
		logger.debug("Inside name setter.");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
