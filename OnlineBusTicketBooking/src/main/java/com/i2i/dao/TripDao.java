package com.i2i.dao;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Trip;

/**
 * Trip Data Access Object (DAO) interface.
 *
 * @author Sivaranjani.D.S
 */
public interface TripDao extends GenericDao<Trip, Long> {
	
	/**
     * Updates a Trip object in the record.
     *
     * @param trip 
     *    Trip object which is to be updated
     *
     * @return Trip
     *     Trip object after updation 
     *     
     * @throws DatabaseException 
     *     If there is any interruption occurred in the database.
     */
	public Trip updateTrip(Trip trip) throws DatabaseException;
}	
	

