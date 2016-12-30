package com.hotelmanagement.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hotelmanagement.dao.DAOFactory;
import com.hotelmanagement.dao.Hotel;
import com.hotelmanagement.dao.HotelDAO;

/**
 * 
 * @author M1024305
 * Booking Controller will be used to Book a Hotel.
 */
@Controller	
public class BookingController {
	/**
	 * 
	 * @param model
	 * @return
	 * Home Page access
	 */
	@RequestMapping(value="/home")
	public String Home(Model model){
		return "home";
		
	}
	
	/**
	 * 
	 * @return
	 * root page
	 */
	@ResponseBody
	@RequestMapping("/")
		String entry(){
			return "My Spring boot";
		}

	@Autowired
    private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param hotelForm
	 * @param model
	 * @return
	 * 
	 * View Low Price Hotels
	 */
	@RequestMapping(value="viewLowPriceHotels")
	@Transactional
	public String viewLowPriceHotels(@ModelAttribute("hotelform") HotelForm hotelForm, Map<String, Object> model){
		HotelDAO hotelDAO = DAOFactory.getDAOFactory("MySQL").getHotelDAO();
		// Not sure why sessionfactory is not getting populated  in DAO impl class.
		Session session = getSession();
		
		List<City> list = hotelDAO.getCities(session);
		model.put("CityList", list);
		return "viewLowPriceHotels";
	}
	
	@RequestMapping(value="bookHotelPage")
	@Transactional
	public String bookHotelPage(@ModelAttribute("hotelform") HotelForm hotelForm, Map<String, Object> model){
		HotelDAO hotelDAO = DAOFactory.getDAOFactory("MySQL").getHotelDAO();
		
		Session session = getSession();
		List<City> list = hotelDAO.getCities(session);
		
		model.put("CityList", list);
		return "bookHotelPage";
	}
	
	@RequestMapping(value="bookRoom")
	public String bookRoom(@ModelAttribute("hotelform") HotelForm hotelForm, Map<String, String> model) throws ParseException, Exception{
		HotelDAO hotelDAO = DAOFactory.getDAOFactory("MySQL").getHotelDAO();
		String returnPage=null;
		Session session = getSession();
		
		boolean availability = hotelDAO.checkRoomAvailability(hotelForm, session);
		if(availability){
			hotelDAO.bookRoom(hotelForm, session);
			returnPage = "bookingSuccess";
		}
		else{
			returnPage = "bookingFailure";
		}
		return returnPage;
	}
	
	 @GetMapping("/")
	 public String showForm(HotelForm hotelForm) {
        return "form";
	 }
	
	@PostMapping("/")
    public String checkBookingInfo(@Valid HotelForm hotelForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
	
	private Session getSession(){
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		return session;
	}
	
	
	

}
