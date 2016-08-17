package com.i2i.service;

import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Reservation;
import com.i2i.model.TripRoute;
import com.i2i.model.User;

/**
 * <p>ReservationService which has method declaration for Reservation.</p>
 * @author Shrie Satheyaa
 * @created 2016-08-02
 */

public interface ReservationService {	
	
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
    Reservation addReservation (User user, TripRoute tripRoute, int noOfSeatsBooked, double totalPrice, String paymentMode, boolean status) throws DatabaseException;
	
    /**
     * <p>Retrieves User Reservation history from the Database.
     * </p>
     * @param  id 
     *     Id of user whose reservation details has to be retrieved
     * 
     * @return List<Reservation>
     *     List of Reservations made by User.
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
     */
    List<Reservation> getReservationByUser(User user)throws DatabaseException; 
}
