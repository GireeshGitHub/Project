package com.hotelmanagement.dao;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(String factoryNumber){
		switch(factoryNumber){
		case "MySQL": return new HibernateDAOImpl();		
		}
		return null;
	}
	
	public abstract HotelDAO getHotelDAO();

}
