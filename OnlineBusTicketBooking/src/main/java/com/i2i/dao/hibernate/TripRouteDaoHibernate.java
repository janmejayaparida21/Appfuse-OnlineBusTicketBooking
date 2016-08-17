package com.i2i.dao.hibernate;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.dao.TripRouteDao;
import com.i2i.dao.hibernate.GenericDaoHibernate;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;
import com.i2i.model.TripRoute;

/**
 * <p>This class interacts with hibernate session to retrieve TripRoute objects.
 * </p>
 *
 * @author Sivaranjani.D.S
 */
@Repository ("tripRouteDao")
@Transactional
public class TripRouteDaoHibernate extends GenericDaoHibernate<TripRoute, Long> implements TripRouteDao {

    /**
     * Constructor to create a Generics-based version using Route as the entity
     */
    public TripRouteDaoHibernate() {
        super(TripRoute.class);
    }
    
    /**
     * <p>
     * Retrieves a list of Trip Route objects for given route object and date of travel from the database.
     * </p>
     *
     * @param route 
     *     Route object for TripRoute which is to be retrieved. 
     * 
     * @param dateOfTravel 
     *     Date of travel for Trip. 
     * 
     * @return tripRoutes
     *    List of TripRoute objects retrieved
     *    
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
     */
    public List<TripRoute> retrieveTripRoutes (Route route, Date dateOfTravel) throws DatabaseException {
        List<TripRoute> tripRoutes = null;
        Session session = getSession();
        try{
            String hql = "FROM " + TripRoute.class.getName() + " tripRoute WHERE tripRoute.route =:route "+
                         "and tripRoute.dateOfTravel =:dateOfTravel";
            Query query = session.createQuery(hql);
            query.setParameter("route", route);
            query.setParameter("dateOfTravel", dateOfTravel);
            tripRoutes = query.list();
        } catch (HibernateException e) {
            throw new DatabaseException("Some problem occured while retrieving route records with route id"+
                                        route.getId() +" and date:"+ dateOfTravel + " records", e);
        } finally {
        	session.flush(); 
        } 
        return tripRoutes; 
    } 
	
    /**
     * Retrieves a Trip Route object for the given Id from database.
     *
     * @param id 
     *    Id of the Trip Route to be retrieved
     *
     * @return tripRoute
     *    TripRoute object that matches the given Id.
     *
     * @throws DatabaseException 
     *     If there is any interruption while retrieving record from the database.
     */
    public TripRoute retrieveTripRouteById (int id) throws DatabaseException {
        Session session = getSession();
        TripRoute tripRoute = null;
        try {
        	tripRoute = (TripRoute)session.get(TripRoute.class, id);
        } catch (HibernateException e) {
            throw new DatabaseException("Something went wrong while getting Trip Route details of id:" 
                                        + tripRoute.getId(),e); 
        } finally {
        	session.flush(); 
        }
        return tripRoute;
    }
}
