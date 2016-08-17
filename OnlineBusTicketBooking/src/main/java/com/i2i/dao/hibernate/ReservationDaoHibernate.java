package com.i2i.dao.hibernate;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.dao.ReservationDao;
import com.i2i.dao.hibernate.GenericDaoHibernate;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Reservation;
import com.i2i.model.User;

/**
 * <p>ReservationDaoHibernate which permits all tasks related to Reservation.
 * </p>
 * @author Shrie Satheyaa
 * @created 2016-08-01
 */
@Repository("reservationDao")
@Transactional
public class ReservationDaoHibernate extends GenericDaoHibernate<Reservation, Long> implements ReservationDao {
    
    /**
     * Constructor that sets the entity to Reservation.class.
     */
    public ReservationDaoHibernate() {
        super(Reservation.class);
    }	
	
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
	public void insertReservation(Reservation reservation) throws DatabaseException{
	    Session session = getSession();
	    try {
	    	if (reservation.getNoOfSeatsBooked() <= reservation.getTripRoute().getTrip().getSeatVacancy()) {
	            session.save(reservation);
	            session.flush();
	    	} else {
	    		throw new DatabaseException("Sorry. We dont have enough seats!");
	    	}
	    } catch (HibernateException e) {
	    	throw new DatabaseException("Some problem occured while inserting reservation details with id" 
	                    + reservation.getId() + " records", e);
	    } 
	}
	
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
	public List<Reservation> retrieveReservationsByUser(User user) throws DatabaseException{
		List<Reservation> reservations = null;
		System.out.println("DAO : " + user);
		Session session = getSession();
		try{
			String hql = "FROM " + Reservation.class.getName() + " reservation WHERE reservation.user =:user ";
			Query query = session.createQuery(hql);
			query.setParameter("user", user);
			reservations = query.list();
			return reservations;
		} catch (HibernateException e) {
			throw new DatabaseException("Some problem occured while retrieving reservation", e);
	    } finally {
	       	session.flush(); 
	    }
	}
}
	
