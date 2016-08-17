package com.i2i.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.dao.RouteDao;
import com.i2i.dao.hibernate.GenericDaoHibernate;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;

/**
 * This class interacts with hibernate session to 
 * retrieve Route objects.
 *
 * @author Sivaranjani.D.S
 */
@Repository ("routeDao")
@Transactional
public class RouteDaoHibernate extends GenericDaoHibernate<Route, Long> implements RouteDao {

    /**
     * Constructor to create a Generics-based version using Route as the entity
     */
    public RouteDaoHibernate() {
        super(Route.class);
    }

    /**
     * <p>
     * Retrieves a specific Route record from the database.
     * </p>
     *
     * @param sourceCityName 
     *     Source city of the route which is to be retrieved. 
     * 
     * @param destinationCityName 
     *     Destination city of the route which is to be retrieved. 
     *     
     * @return routes
     *     List of Route objects retrieved from the database.
     *      
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
     */
    public List<Route> retrieveRoute (String sourceCityName, String destinationCityName) throws DatabaseException {
        Session session = null;
        try {
            session = getSession();
        } catch (HibernateException e) {
        	e.printStackTrace();
        }
        List<Route> routes = null;
        try{
            String hql = "FROM " + Route.class.getName() + " route WHERE route.sourceCity.name =:sourceCityName "+
                          "and route.destinationCity.name =:destinationCityName";
            Query query = session.createQuery(hql);
            query.setParameter("sourceCityName", sourceCityName);
            query.setParameter("destinationCityName", destinationCityName);
            routes = query.list();
        } catch (HibernateException e) { 
            throw new DatabaseException("Some problem occured while retrieving route records with "+
                                        sourceCityName +" and "+ destinationCityName + " records", e);
        }
        return routes;
    }
}