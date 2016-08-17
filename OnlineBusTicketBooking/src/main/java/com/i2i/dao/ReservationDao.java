package com.i2i.dao;

import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Reservation;
import com.i2i.model.User;

/**
 * <p>Dao which permits all tasks related to Reservation.
 * </p>
 * @author Shrie Satheyaa
 * @created 2016-08-01
 */
public interface ReservationDao extends GenericDao<Reservation, Long> {
	
	/**
     * <p>
     * Inserts Reservation details into the database.
     * </p>
     *
     * @param reservation 
     *     Reservation object that is to be inserted into the database. 
     *     
     * @throws DatabaseException 
     *     If there is any interruption while inserting record in the database.
     */
	public void insertReservation(Reservation reservation) throws DatabaseException;
	
	/**
     * <p>
     * retrieve Reservation details of a particular user from the database
     * </p>
     *
     * @param user 
     *     User whose reservation details has to be retrieved
     *     
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
     */
	public List<Reservation> retrieveReservationsByUser(User user)throws DatabaseException;
	
}
