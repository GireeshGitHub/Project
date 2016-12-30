package com.hotelmanagement.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class City {
	@NotNull
	@NotEmpty(message="Please select City")
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public City(String cityName){
		this.cityName=cityName;		
	}
	
	public City(){
		
	}
	
	
}
