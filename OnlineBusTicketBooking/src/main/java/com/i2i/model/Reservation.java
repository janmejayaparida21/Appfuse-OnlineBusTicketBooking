package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class represents the basic "Reservation" object 
 * 
 * <p> Contains various attributes of Bus ticket reservation and its getters and setters
 * 
 * @author Sivaranjani
 * @created 12-08-2016
 */

@Entity
@Table (name = "Reservations")
public class Reservation {
	
	@Id
	@Column (name = "Id")
	@GeneratedValue
	private int id;
	
	@ManyToOne 
	@JoinColumn (name = "User_Id")
	private User user;
	
	@ManyToOne 
	@JoinColumn (name = "Trip_Route_Id")
	private TripRoute tripRoute; 
	
	@Column (name = "No_Of_Seats_Booked")
	private int noOfSeatsBooked;
	
	@Column (name = "Total_Price")
	private double totalPrice;
	
	@Column (name = "Payment_Mode")
	private String paymentMode;
	
	@Column (name = "Status")
	private boolean status;
	
	public Reservation() {
	}

	public Reservation(User user, TripRoute tripRoute, int noOfSeatsBooked, double totalPrice, 
			           String paymentMode, boolean status) {
		this.status = status;
		this.user = user;
		this.noOfSeatsBooked = noOfSeatsBooked;
		this.paymentMode = paymentMode;
		this.tripRoute = tripRoute;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TripRoute getTripRoute() {
		return tripRoute;
	}

	public void setTripRoute(TripRoute tripRoute) {
		this.tripRoute = tripRoute;
	}

	public int getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}
	
	public void setNoOfSeatsBooked(int noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

}
