package com.hotelmanagement.dao;

public class HibernateDAOImpl extends DAOFactory{

	@Override
	public HotelDAO getHotelDAO() {
		// TODO Auto-generated method stub
		return new HotelDAOImpl();
	}

}
