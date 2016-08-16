package com.i2i.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.TripDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Trip;
import com.i2i.service.TripService;


/**
 * Implementation of TripService interface.
 *
 * @author Sivaranjani.D.S
 */
@Service("tripService")
public class TripServiceImpl extends GenericManagerImpl<Trip, Long> implements TripService {

    TripDao tripDao;

    @Autowired
    public TripServiceImpl(TripDao tripDao) {
        super(tripDao);
        this.tripDao = tripDao;
    }
    
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
    public Trip modifySeatVacancy (int noOfSeatsBooked, Trip trip) throws DatabaseException {
    	int seatCount = trip.getSeatVacancy();
    	seatCount = seatCount - noOfSeatsBooked;
    	trip.setSeatVacancy(seatCount);
        return tripDao.updateTrip(trip);
    }
}