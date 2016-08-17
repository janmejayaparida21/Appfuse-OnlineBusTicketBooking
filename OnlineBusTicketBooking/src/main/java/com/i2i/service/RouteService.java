package com.i2i.service;

import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;

/**
 * <p> Business Service Interface to handle communication between web and persistence layer.
 * </p>
 *
 * @author Sivaranjani.D.S
 */
public interface RouteService extends GenericManager<Route, Long> {
	
	/**
	 * <p>Retrieves a specific Route record for given Source city and Destination city.
	 * </p>
	 * @param sourceCityName 
     *     Source city of the route which is to be retrieved. 
     * 
     * @param destinationCityName 
     *     Destination city of the route which is to be retrieved. 
     *     
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
	 */
    List<Route> getRoute(String source, String destination) throws DatabaseException;
}


