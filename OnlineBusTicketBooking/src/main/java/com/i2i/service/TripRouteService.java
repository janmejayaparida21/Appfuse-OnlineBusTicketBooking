package com.i2i.service;

import java.sql.Date;
import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;
import com.i2i.model.TripRoute;
/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author Shrie Satheyaa
 */
public interface TripRouteService extends GenericManager<TripRoute, Long> {
	
	/**
	 * <p>Gets Route object and Date of travel as input and returns the TripRoute object 
	 * for the corresponding route and date of travel.
	 * </p>
	 * @param route 
     *     Object of Route for which Trip Route object is to be found. 
     * 
     * @param dateOfTravel 
     *     date of travel for Trip.  
     *     
     * @throws DatabaseException 
     *     If there is any interruption occurred in the database.
	 */
	List<TripRoute> getTripRoutes (Route route, Date dateOfTravel) throws DatabaseException;
	
	/**
     * Gets a Trip Route record for the given Id.
     *
     * @param id 
     *    Id of the Trip Route to be found
     *
     * @return tripRoute
     *    TripRoute object which matches the given id
     *
     * @throws DatabaseException 
     *     If there is any interruption occurred in the database.
     */
    TripRoute getTripRouteById (int id) throws DatabaseException;
	
}