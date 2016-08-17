package com.i2i.dao.hibernate;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.dao.TripDao;
import com.i2i.dao.hibernate.GenericDaoHibernate;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Trip;

/**
 * This class interacts with hibernate session to 
 * retrieve Trip objects.
 *
 * @author Sivaranjani.D.S
 */
@Repository ("tripDao")
@Transactional
public class TripDaoHibernate extends GenericDaoHibernate<Trip, Long> implements TripDao {

    /**
     * Constructor to create a Generics-based version using Route as the entity
     */
    public TripDaoHibernate() {
        super(Trip.class);
    }
    
	/**
	 * Updates a Trip object in the record.
	 *
	 * @param trip 
	 *    Trip object which is to be updated
	 *
	 * @return Trip
	 *     Trip object after update 
	 *     
	 * @throws DatabaseException 
	 *     If there is any interruption while updating record in the database.
	 */
	public Trip updateTrip(Trip trip) throws DatabaseException{
	    Session session = getSession();
	    try{
	        session.update(trip);
	        return trip;
	    } catch (HibernateException e) {
	        throw new DatabaseException("Some problem occured while updating trip with id: " + trip.getId() +
	        		                   " records", e);
	    } finally {
	    	session.flush();
	    }
	}
}
