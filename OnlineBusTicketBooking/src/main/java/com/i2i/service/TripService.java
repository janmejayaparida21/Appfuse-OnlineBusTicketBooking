package com.i2i.service;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Trip;

/**
 * <p>Business Service Interface to handle communication between web and persistence layer.
 * </p>
 *
 * @author Sivaranjani.D.S
 */
public interface TripService extends GenericManager<Trip, Long> {

    /**
     * Updates a Trip object in the record.
     *
     * @param noOfSeatsBooked 
     *    noOfSeatsBooked booked by the user.
     *
     * @return Trip
     *     Trip object after modifying number of seat vacancies.
     *     
     * @throws DatabaseException 
     *     If there is any interruption while updating record in the database.
     */
    Trip modifySeatVacancy (int noOfSeatsBooked, Trip trip) throws DatabaseException;
}

