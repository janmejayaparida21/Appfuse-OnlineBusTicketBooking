package com.i2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.RouteDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Route;
import com.i2i.service.RouteService;

/**
 * Implementation of RouteService interface.
 *
 * @author Sivaranjani.D.S
 */
@Service("routeService")
public class RouteServiceImpl extends GenericManagerImpl<Route, Long> implements RouteService {
    RouteDao routeDao;

    @Autowired
    public RouteServiceImpl(RouteDao routeDao) {
        super(routeDao);
        this.routeDao = routeDao;
    }
	
    /**
     * <p>Retrieves a specific Route record for given Source city and Destination city.
     * </p>
     * @param sourceCityName 
     *     Source city of the route which is to be retrieved. 
     * 
     * @param destinationCityName 
     *     Destination city of the route which is to be retrieved. 
     *     
     * @throws DatabaseException 
     *     If there is any interruption while retrieving records from the database.
     */
    public List<Route> getRoute (String sourceCityName, String destinationCityName) throws DatabaseException {
        return routeDao.retrieveRoute(sourceCityName, destinationCityName);
    }
}
