package com.hotelmanagement.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Hotel")
@Table(name = "hotel")
public class Hotel {
	
	@Id
	@Column(name="hotel_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelId;
	
	@Column(name="hotel_name")
	private String hotelName;
	
	@Column(name="number_of_rooms")
	private int numberOfRooms;
	
	@Column(name="city")
	private String city;
	
	@Column(name="tariff")
	private int tariff;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTariff() {
		return tariff;
	}

	public void setTariff(int tariff) {
		this.tariff = tariff;
	}
	
	public Hotel(String city){
		this.city=city;
	}
	
	public Hotel(){
		
	}

}
