package com.hotelmanagement.controller;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

public class HotelForm {
	
	
	
	@NotNull
	@NotEmpty(message="Please select Hotel")
	private String hotelName;
	
	@Autowired
	@NotEmpty(message="Please select City")
	private City city;
	
	@NotNull
	@NotEmpty(message="Please enter checkin Date")
	@Future
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private String checkinDate;
	
	@NotNull
	@NotEmpty(message="Please enter checkout Date")
	@Future
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private String checkoutDate;
	
	@NotNull
	@Min(1)
	private int numberOfRooms;
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	
	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public HotelForm(){
		
	}

}
