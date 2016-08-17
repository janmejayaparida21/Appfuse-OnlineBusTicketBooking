package com.i2i.model;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class represents the basic "TripRoute" object. 
 * 
 * <p> Contains various attributes of Trip and its getters and setters</p>
 * 
 * @author Sivaranjani
 * @created 12-08-2016
 */

@Entity
@Table (name="TripRoutes")
public class TripRoute {
	
	@Id
	@Column (name = "Id")
	@GeneratedValue
	private int id;
	
	@ManyToOne 
	@JoinColumn (name = "Route_Id")
	private Route route;
	
	@ManyToOne 
	@JoinColumn (name = "Trip_Id")
	private Trip trip;
	
	@Column (name = "Departure_Time")
	private Time departureTime;
	
	@Column (name = "Arrival_Time")
	private Time arrivalTime;
	
	@Column (name = "Price")
	private double price;
	
	@Column (name = "Date_Of_Travel")
	private Date dateOfTravel;
	
	@Column (name = "Is_Active")
	private boolean isActive;
	
	@ManyToOne 
	@JoinColumn (name = "Created_By")
	private User createdBy;
	
	@Column (name = "Created_At")
	private Date createdAt;
	
	@ManyToOne 
	@JoinColumn (name = "Modified_By")
	private User modifiedBy;
	
	@Column (name = "Modified_At")
	private Date modifiedAt; 
    
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn (name = "Trip_Route_Id")
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Route getRoute() {
		return route;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}
	
	public Trip getTrip() {
		return trip;
	}
	
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	public Time getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	
	public Time getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getDateOfTravel() {
		return dateOfTravel;
	}
	
	public void setDateOfTravel(Date dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

}


 
