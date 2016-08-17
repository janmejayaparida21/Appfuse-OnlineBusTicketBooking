package com.i2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.ReservationDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Reservation;
import com.i2i.model.TripRoute;
import com.i2i.model.User;
import com.i2i.service.ReservationService;
import com.i2i.service.TripService;
import com.i2i.exception.InputException;

/**
 * <p>ReservationServiceImpl which permits to perform all the tasks related to Reservation</p>
 * 
 * @author Shrie Satheyaa
 * @created 2016-08-02
 */
@Service("reservationService")
public class ReservationServiceImpl extends GenericManagerImpl<Reservation, Long> implements ReservationService {
    ReservationDao reservationDao;	
    TripService tripService;
	
    @Autowired
    public ReservationServiceImpl(ReservationDao reservationDao, TripService tripService) {
    	super(reservationDao);
        this.reservationDao = reservationDao;
        this.tripService = tripService;
    }
    
    /**
     * <p>Inserts Reservation details into the database.
     * </p>
     * @param user
     *     User Object who booked ticket
     * @param tripRoute  
     *     Trip route in which the user booked ticket
     * @param noOfSeatsBooked
     *     Number of seat booked by the user    
     * @param totalPrice
     *     total price for the ticket   
     * @param paymentMode
     *     payment mode used by the user   
     * @param status
     *     Status of reservation
     * 
     * @return reservation
     *     reservation object after successful reservation.
     *     
     * @throws DatabaseException 
     *     If there is any interruption while inserting record in the database.
     */
    public Reservation addReservation (User user, TripRoute tripRoute, int noOfSeatsBooked, double totalPrice, String paymentMode, boolean status) throws DatabaseException {
        Reservation reservation = new Reservation(user, tripRoute, noOfSeatsBooked, totalPrice, paymentMode, status);
        reservationDao.insertReservation(reservation);
        tripRoute.setTrip(tripService.modifySeatVacancy(noOfSeatsBooked, tripRoute.getTrip()));
        reservation.setTripRoute(tripRoute);
        return reservation;
    }
    
    /**
     * <p>Retrieves User Reservation history from the Database.
     * </p>
     * @param  user 
     *     User whose reservation details has to be retrieved
     * 
     * @return List<Reservation>            
     *     List of Reservations made by User.
     *     
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
	 */
    public List<Reservation> getReservationByUser (User user)throws DatabaseException {
        System.out.println("SERVICING : " + user);
        return reservationDao.retrieveReservationsByUser(user);
    }
}

