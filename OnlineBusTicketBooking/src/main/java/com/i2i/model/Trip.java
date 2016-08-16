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
 * This class represents the basic "Trip" object
 * <p>Contains various attributes of Trip, and its getters and setters </p> 
 * @author Shrie Satheyaa
 * @version 1.0
 * @created 2016-07-23
 */

@Entity
@Table (name="Trips")
public class Trip {
	
	@Id
	@Column (name = "Id")
	@GeneratedValue
    private int id;
	
	@Column (name = "Seat_Vacancy")
    private int seatVacancy;
	
	@ManyToOne 
	@JoinColumn (name = "Bus_Id")
    private Bus bus;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn (name = "Trip_Id")
    private Set<TripRoute> tripRoutes = new HashSet<TripRoute> ();
	
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
    
	public Trip() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeatVacancy() {
		return seatVacancy;
	}

	public void setSeatVacancy(int seatVacancy) {
		this.seatVacancy = seatVacancy;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Set<TripRoute> getTripRoutes() {
		return tripRoutes;
	}

	public void setTripRoutes(Set<TripRoute> tripRoutes) {
		this.tripRoutes = tripRoutes;
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

}
