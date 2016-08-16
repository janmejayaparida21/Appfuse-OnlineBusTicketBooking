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
/**
 * This class represents the basic "City" object
 * <P>Contains various attributes of City and their getter setters.</p>
 * 
 * @author Anupriya-Ideas2It
 * @version 1.0
 */

@Entity
@Table (name="Cities")
public class City {
	
	@Id
	@Column (name = "Id")
	@GeneratedValue
	private int id;
	
	@Column (name = "Name")
	private String name;
	
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
	@JoinColumn (name = "Source_City_Id")
	private Set<Route> sourceCityRoutes = new HashSet<Route>();
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn (name = "Destination_City_Id")
	private Set<Route> destinationCityRoutes = new HashSet<Route>();
	
	public City() {
		
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

	public Set<Route> getSourceCityRoutes() {
		return sourceCityRoutes;
	}

	public void setSourceCityRoutes(Set<Route> sourceCityRoutes) {
		this.sourceCityRoutes = sourceCityRoutes;
	}

	public Set<Route> getDestinationCityRoutes() {
		return destinationCityRoutes;
	}

	public void setDestinationCityRoutes(Set<Route> destinationCityRoutes) {
		this.destinationCityRoutes = destinationCityRoutes;
	}
}
