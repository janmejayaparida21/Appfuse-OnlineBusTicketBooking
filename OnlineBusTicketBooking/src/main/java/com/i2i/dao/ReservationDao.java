package com.i2i.dao;

import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Reservation;

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
     *     If there is any interruption occurred in the database.
     */
	public void insertReservation(Reservation reservation) throws DatabaseException;
	
	/**
     * <p>
     * retrieve Reservation details of a particular user from the database
     * </p>
     *
     * @param name 
     *     user name whose reservation details has to be retrieved
     *     
     * @throws DatabaseException 
     *     If there is any interruption occurred in the database.
     */
	public List<Reservation> retrieveReservationsByUserName (String name)throws DatabaseException;
	
}
