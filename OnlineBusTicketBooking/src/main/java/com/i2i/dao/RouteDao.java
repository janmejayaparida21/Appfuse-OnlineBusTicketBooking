package com.i2i.dao;

import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;

/**
 * Route Data Access Object (DAO) interface.
 *
 * @author Sivaranjani.D.S
 */
public interface RouteDao extends GenericDao<Route, Long> {
	
	/**
	 * <p>
	 * Retrieves a specific Route record from the database.
	 * </p>
	 *
	 * @param sourceCityName 
	 *     Source city of the route which is to be retrieved. 
	 * 
	 * @param destinationCityName 
	 *     Destination city of the route which is to be retrieved. 
	 *     
	 * @throws DatabaseException 
	 *     If there is any interruption while retrieving records from the database.
	 */
	List<Route> retrieveRoute (String sourceCityName, String destinationCityName) throws DatabaseException;
}


