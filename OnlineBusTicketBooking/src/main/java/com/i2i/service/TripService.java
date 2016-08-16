package com.i2i.service;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Trip;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author Sivaranjani.D.S
 */
public interface TripService extends GenericManager<Trip, Long> {
	
	/**
     * Updates a Trip object in the record.
     *
     * @param noOfSeatsBooked 
     *    noOfSeatsBooked booked by the updated.
     *
     * @return Trip
     *     Trip object after modifying number of seat vacancies
     *     
     * @throws DatabaseException 
     *     If there is any interruption occurred in the database.
     */
    Trip modifySeatVacancy (int noOfSeatsBooked, Trip trip) throws DatabaseException;
}

