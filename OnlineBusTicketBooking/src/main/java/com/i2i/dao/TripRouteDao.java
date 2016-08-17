package com.i2i.dao;

import java.sql.Date;
import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;
import com.i2i.model.TripRoute;

/**
 * TripRoute Data Access Object (DAO) interface.
 *
 * @author Sivaranjani.D.S
 */
public interface TripRouteDao extends GenericDao<TripRoute, Long> {
	
	/**
     * <p>
     * Retrieves a list of Trip Route objects for given route object and date of travel from the database.
     * </p>
     *
     * @param route 
     *     Route object for TripRoute which is to be retrieved. 
     * 
     * @param dateOfTravel 
     *     Date of travel for Trip. 
     * 
     * @return tripRoutes
     *    List of TripRoute objects retrieved
     *    
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
     */
	public List<TripRoute> retrieveTripRoutes (Route route, Date dateOfTravel) throws DatabaseException;
	
	/**
     * Retrieves a Trip Route object for the given Id from database.
     *
     * @param id 
     *    Id of the Trip Route to be retrieved
     *
     * @return tripRoute
     *    TripRoute object that matches the given Id.
     *
     * @throws DatabaseException 
     *     If there is any interruption while retrieving record from the database.
     */
	public TripRoute retrieveTripRouteById (int id) throws DatabaseException;
}

