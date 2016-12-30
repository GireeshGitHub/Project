package com.hotelmanagement.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotelmanagement.controller.City;
import com.hotelmanagement.controller.HotelForm;


@Repository
@Transactional
public class HotelDAOImpl extends HibernateUtil implements HotelDAO {
	SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/yyyy");
	
	public List<City> getCities(Session session){
		List<City> cityList = new ArrayList<City>();
		Query query = session.createQuery("select distinct city from Hotel");
		List<String> queryResultList = query.list();
		for(String val: queryResultList){
			cityList.add(new City(val));
		}
		return cityList;
	}
	/**
	 * Fetches top 5 low priced hotels in the ascending order
	 */
	@Override
	public List<Hotel> getLowPricedHotels(String cityName, Session session) {
		// TODO Auto-generated method stub
		List<Hotel> hotelList = new ArrayList<Hotel>();
		Criteria cr = session.createCriteria(Hotel.class).add(Restrictions.eq("city", cityName)).addOrder(Order.asc("tariff")).setMaxResults(5);
		hotelList = cr.list();
		return hotelList;
	}

	/**
	 * Fetches hotels in the selected City
	 */
	@Override
	public List<Hotel> getHotelsInCity(String cityName, Session session) {
		// TODO Auto-generated method stub
		
		List<Hotel> hotelList = new ArrayList<Hotel>();
		Criteria cr = session.createCriteria(Hotel.class).add(Restrictions.eq("city", cityName));
		hotelList = cr.list();
		return hotelList;
	}
	
	/**
	 * Books a room in hotel
	 */
	@Override
	public HotelBooking bookRoom(HotelForm hotelForm, Session session) throws HibernateException, Exception{
		// TODO Auto-generated method stub
		
		HotelBooking hotelBooking = setDAOValues(hotelForm);
		session.save(hotelBooking);
		
		return null;
	}
	
	private HotelBooking setDAOValues(HotelForm hotelForm) throws ParseException{
		HotelBooking hb = new HotelBooking();
		
		String hotelName = hotelForm.getHotelName();
		String hotelInfo[] = hotelName.split("~");
		int hotelId = Integer.parseInt(hotelInfo[0]);	
		int tariff = Integer.parseInt(hotelInfo[1]);
		hb.setHotelId(hotelId);
		
		hb.setCheckinDate(formatter.parse(hotelForm.getCheckinDate()));
		hb.setCheckoutDate(formatter.parse(hotelForm.getCheckoutDate()));
		hb.setRoomsBooked(hotelForm.getNumberOfRooms());
		hb.setBookingDate(new Date());
		hb.setAmountTOBePaid(tariff*hotelForm.getNumberOfRooms());
		
		/*Booking reference number*/
		Calendar calendar = Calendar.getInstance();
		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int hour       = calendar.get(Calendar.HOUR);        
		int minute     = calendar.get(Calendar.MINUTE);
		int second     = calendar.get(Calendar.SECOND);
		
		String bookingRefNum = year+""+month+""+dayOfMonth+""+hour+""+minute+""+second+"-"+hotelId;
		hb.setBookingRefNumber(bookingRefNum);
		return hb;
	}
	/**
	 * Check room availability
	 */
	@Override
	public boolean checkRoomAvailability(HotelForm hotelForm, Session session) throws ParseException{
		// TODO Auto-generated method stub
		boolean roomAvailability = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		SimpleDateFormat sdf1 = new SimpleDateFormat("");
		String checkinDate=null;
		String checkoutDate=null;
		Integer roomsBooked = null;
		
		String hotelName = hotelForm.getHotelName();
		String hotelInfo[] = hotelName.split("~");
		int hotelId = Integer.parseInt(hotelInfo[0]);
		int numberOfRooms = Integer.parseInt(hotelInfo[2]);
		int roomsToBeBooked = hotelForm.getNumberOfRooms();
		
			checkinDate = sdf.format(formatter.parse(hotelForm.getCheckinDate()));
			checkoutDate = sdf.format(formatter.parse(hotelForm.getCheckoutDate()));
		
		
		String query = "select SUM(rooms_booked) from hotel_booking where checkin_date <= str_to_date('"+checkoutDate+"', '%Y-%m-%d') "+
						" and checkout_date >= str_to_date('"+checkinDate+"', '%Y-%m-%d') and hotel_id="+hotelId;
		
		SQLQuery sqlQuery = session.createSQLQuery(query);
		
		List<Object[]> entities = sqlQuery.list();
		
		for(Object entity : entities){
			if(entity!=null)
				roomsBooked = ((BigDecimal)entity).intValue();
		}
		if(roomsBooked!=null && roomsBooked < numberOfRooms && (roomsToBeBooked+roomsBooked <= numberOfRooms))
			roomAvailability = true;
		/*When blank database*/
		if(roomsBooked == null)
			roomAvailability = true;
		return roomAvailability;
	}
	


}
