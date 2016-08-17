package com.i2i.model;

import java.util.Set;
import java.util.HashSet;
import java.sql.Date;

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
 * This class represents the basic "Bus" object.
 * 
 * <P>Contains various attributes of Bus and their getter setters.</p>
 * 
 * @author Anupriya-Ideas2It
 * @version 1.0
 */

@Entity 
@Table (name = "Buses")
public class Bus {
	
	@Id
	@Column (name = "Id")
	@GeneratedValue
	private int id;
	
	@Column (name = "Registration_Number")
	private String registrationNumber;
	
	@ManyToOne 
	@JoinColumn (name = "Travels_Id")
	private Travels travels;
	
	@Column (name = "Type")
	private String  type;
	
	@Column (name = "Is_Ac")
	private Boolean isAc;
	
	@Column (name = "Total_Number_Of_Seats")
	private int totalNumberOfSeats;
	
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
	@JoinColumn (name = "Bus_Id")
	private Set<Trip> trips = new HashSet<Trip>();
	
	public Bus() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Travels getTravels() {
		return travels;
	}

	public void setTravels(Travels travels) {
		this.travels = travels;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsAc() {
		return isAc;
	}

	public void setIsAc(Boolean isAc) {
		this.isAc = isAc;
	}

	public int getTotalNumberOfSeats() {
		return totalNumberOfSeats;
	}

	public void setTotalNumberOfSeats(int totalNumberOfSeats) {
		this.totalNumberOfSeats = totalNumberOfSeats;
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

	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
}
