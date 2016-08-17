package com.i2i.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.TripRouteDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;
import com.i2i.model.TripRoute;
import com.i2i.service.TripRouteService;

/**
 * <p>Implementation of TripRouteService</p>
 * @author Shrie Satheyaa
 * @created 2016-08-01
 */
@Service("tripRouteService")
public class TripRouteServiceImpl extends GenericManagerImpl<TripRoute, Long> implements TripRouteService {
    TripRouteDao tripRouteDao;

    @Autowired
    public TripRouteServiceImpl(TripRouteDao tripRouteDao) {
        super(tripRouteDao);
        this.tripRouteDao = tripRouteDao;
    }
    
    /**
     * <p>Gets Route object and Date of travel as input and returns the TripRoute object 
     *  for the corresponding route and date of travel.
     * </p>
     * @param route 
     *     Object of Route for which Trip Route object is to be found. 
     * 
     * @param dateOfTravel 
     *     date of travel for Trip.  
     *     
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
     */
    public List<TripRoute> getTripRoutes (Route route, Date dateOfTravel) throws DatabaseException {
    	return tripRouteDao.retrieveTripRoutes(route, dateOfTravel);
    }
    
    /**
     * Gets a Trip Route record for the given Id.
     *
     * @param id 
     *    Id of the Trip Route to be found
     *
     * @return tripRoute
     *    TripRoute object which matches the given id
     *
     * @throws DatabaseException 
     *     If there is any interruption while retrieving record from the database.
     */
    public TripRoute getTripRouteById (int id) throws DatabaseException {
        return tripRouteDao.retrieveTripRouteById(id);
    }
}
