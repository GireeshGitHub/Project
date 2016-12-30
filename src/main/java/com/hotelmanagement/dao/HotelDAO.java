package com.hotelmanagement.dao;

import java.text.ParseException;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hotelmanagement.controller.City;
import com.hotelmanagement.controller.HotelForm;

public interface HotelDAO {
	
	public List<City> getCities(Session session);
	public List<Hotel> getLowPricedHotels(String cityName, Session session);
	public List<Hotel> getHotelsInCity(String cityName, Session session);
	public HotelBooking bookRoom(HotelForm hotelForm,  Session session) throws HibernateException, Exception;
	public boolean checkRoomAvailability(HotelForm hotelForm,  Session session)throws ParseException;

}
