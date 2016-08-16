package com.i2i.model;

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

import java.util.HashSet;
import java.sql.Date;
import java.sql.Time;

/**
 * This class represents the basic "Travels" object.
 * <P>Contains various attributes of Travels and their getter setters.</p>
 * 
 * @author Anupriya
 * @version 1.0
 */

@Entity 
@Table (name = "Travels")
public class Travels {
	
	@Id
	@Column (name = "Id")
	@GeneratedValue
	private int id;
	
	@Column (name = "Name")
	private String name;
	
	@Column (name = "Address")
	private String address;
	
	@Column (name = "Contact_Number")
	private long contactNumber;
	
	
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
	@JoinColumn (name = "Travels_Id")
	private Set<Bus> buses = new HashSet<Bus>();
    
	public Travels() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
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

	public Set<Bus> getBuses() {
		return buses;
	}

	public void setBuses(Set<Bus> buses) {
		this.buses = buses;
	}

}
