package com.hotelmanagement.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="HotelBooking")
@Table(name = "HOTEL_BOOKING")
public class HotelBooking {
	
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(name="hotel_id")
	private int hotelId;
	
	@Column(name="checkin_date")
	private Date checkinDate;
	
	@Column(name="checkout_date")
	private Date checkoutDate;
	
	@Column(name="rooms_booked")
	private int roomsBooked;
	
	@Column(name="booking_ref_number")
	private String bookingRefNumber;
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@Column(name="amount_tobe_paid")
	private int amountTOBePaid;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(int roomsBooked) {
		this.roomsBooked = roomsBooked;
	}

	public String getBookingRefNumber() {
		return bookingRefNumber;
	}

	public void setBookingRefNumber(String bookingRefNumber) {
		this.bookingRefNumber = bookingRefNumber;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getAmountTOBePaid() {
		return amountTOBePaid;
	}

	public void setAmountTOBePaid(int amountTOBePaid) {
		this.amountTOBePaid = amountTOBePaid;
	}
	
	
	

}
