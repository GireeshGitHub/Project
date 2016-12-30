package com.hotelmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotelmanagement.dao.DAOFactory;
import com.hotelmanagement.dao.Hotel;
import com.hotelmanagement.dao.HotelDAO;


@RestController
public class ServicesController {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param cityName
	 * @return
	 * 
	 * Used to fetch top 5 low priced hotels
	 */
	@RequestMapping(value="/getTariff", method= RequestMethod.POST)
	public List<Hotel> getLowPricedHotels(@RequestParam("cityName") String cityName){
		List<Hotel> list = new ArrayList<Hotel>();
		// Not sure why sessionfactory is not available in DAO impl class.
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		
		HotelDAO hotelDAO = DAOFactory.getDAOFactory("MySQL").getHotelDAO();
		list = hotelDAO.getLowPricedHotels(cityName, session);
		return list;
	}
	
	/**
	 * 
	 * @param cityName
	 * @return
	 * 
	 * Fetches the list of Hotels available in selected City
	 */
	@RequestMapping(value="/getHotels", method= RequestMethod.POST)
	public List<Hotel> getHotels(@RequestParam("cityName") String cityName){
		List<Hotel> list = new ArrayList<Hotel>();
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		
		HotelDAO hotelDAO = DAOFactory.getDAOFactory("MySQL").getHotelDAO();
		list = hotelDAO.getHotelsInCity(cityName, session);
		
		return list;
	}

}
