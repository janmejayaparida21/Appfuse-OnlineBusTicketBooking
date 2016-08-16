package com.i2i.webapp.controller;

import com.i2i.Constants;
import com.i2i.dao.SearchException;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Reservation;
import com.i2i.model.Route;
import com.i2i.model.TripRoute;
import com.i2i.model.User;
import com.i2i.service.GenericService;
import com.i2i.service.ReservationService;
import com.i2i.service.RouteService;
import com.i2i.service.TripRouteService;
import com.i2i.service.UserManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controller to perform basic operations 
 *
 * @author Sivaranjani.D.S 
 */
@Controller
public class UserController {
    private UserManager userManager = null;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    @Autowired
    RouteService routeService;
    
    @Autowired
    TripRouteService tripRouteService;
    
    @Autowired
    ReservationService reservationService;
    
    
    private TripRoute tripRoute = null;
    private ModelAndView modelAndView = new ModelAndView();
    private Reservation reservation = null;
    private User user = null;

    @RequestMapping("/admin/users*")
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.USER_LIST, userManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(userManager.getUsers());
        }
        return new ModelAndView("admin/userList", model.asMap());
    }
    
    /**
     * <p>Returns the Search Bus page to the user</p>
     *
     * @return ModelAndView
     *     Returns ModelAndView object which is rendered with the View 'SearchBus'
     *  
     */
    @RequestMapping("/SearchBus")
    public ModelAndView getSearchBusPage() {
    		return new ModelAndView("SearchBus");
    }
    
    /**
     * <p>Returns the User Home  page to the user</p>
     *
     * @return ModelAndView
     *     Returns ModelAndView object which is rendered with the View 'UserHomePage'
     *  
     */
    @RequestMapping("/UserHomePage")
    public ModelAndView getHomePage() {
    		return new ModelAndView("UserHomePage");
    }
    
    
    /**
    * <p>Takes source city, destination city, date of travel as input and
    *  returns the details of available busses if bus is available for the given input </p>
    *   
    * @param source
    *     Source City given by the user
    * @param destination  
    *     destination City given by the user
    * @param date
    *     date of travel given by the user
    *
    * @return ModelAndView
    *     Returns ModelAndView object which is rendered with the View 'ResultBus'
    *     Returns ModelAndView object which is rendered with the View 'ExceptionPage' when exception occurred
    */
    @RequestMapping(value = "/Search",method = RequestMethod.POST)
    public ModelAndView test(@RequestParam("source") String source,
 		                    @RequestParam("destination") String destination,@RequestParam("date") String date) {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date travelDate =null;
        try {
            travelDate = df.parse(date);
        } catch (ParseException e) {
        	e.printStackTrace();     
            return new ModelAndView("ExceptionPage");
        }
       java.sql.Date dateOfTravel = new java.sql.Date(travelDate.getTime());
 	   Map<String, Object> model = new HashMap<String, Object>();
       List<Route> routes = null;
       try {
           routes = routeService.getRoute(source, destination);
       } catch (DatabaseException e) {
    	   e.printStackTrace(); 
     	   return new ModelAndView("ExceptionPage");
       }
       for (Route route : routes) {
           try {
               model.put("tripRoutes", tripRouteService.getTripRoutes(route, dateOfTravel));
           } catch (DatabaseException e) {
     	       GenericService.exceptionWriter(e);
     	       return new ModelAndView("ExceptionPage");
           }
       }
       modelAndView.addAllObjects(model);
       modelAndView.setViewName("ResultBus"); 
       return modelAndView;
        
    }      
    
    /**
     * <p>Gets the required trip from the user and redirects to booking page</p>
     *
     * @param tripRouteId
     *     tripRouteId which is to be booked by the user
     *
     * @return ModelAndView
     *     Returns ModelAndView object which is rendered with the View 'PayNow'
     *     Returns ModelAndView object which is rendered with the View 'ExceptionPage' when exception occurred
     */
    @RequestMapping(value = "/ConfirmBooking",method = RequestMethod.POST)
    public ModelAndView getBookingForm(@RequestParam("tripRoutes")int tripRouteId) {
      
      
        Map<String, Object> model = new HashMap<String, Object>();
        List<TripRoute> tripRoutes = new ArrayList<TripRoute>();
      
        try {
          
            tripRoutes.add(tripRouteService.getTripRouteById(tripRouteId));
            model.put("tripRoute", tripRoutes );
            for (TripRoute tripRoute : tripRoutes) {
                this.tripRoute = tripRoute;
            }
            modelAndView.addAllObjects(model);
            modelAndView.setViewName("PayNow");
            return modelAndView;
        } catch (DatabaseException e) {
             GenericService.exceptionWriter(e);
             return new ModelAndView("ExceptionPage");          
        }
    }
    
    /**
     * <p>Returns the User Profile page to the user</p>
     *
     * @return ModelAndView
     *     Returns ModelAndView object which is rendered with the View 'profile'
     *  
     */
    @RequestMapping("/profile")
    public ModelAndView getProfilePage(final HttpServletRequest request) {
    	String current_user = request.getRemoteUser();
    	user = userManager.getUserByUsername(current_user);
    	Map<String, User> model = new HashMap<String, User>();
    	model.put("user", user);
  	    modelAndView.addAllObjects(model);
        modelAndView.setViewName("profile");
        return modelAndView;
    }
    
    /**
     * <p>Returns the User Booking History page to the user</p>
     *
     * @return ModelAndView
     *     Returns ModelAndView object which is rendered with the View 'bookingHistory'
     *  
     */
    @RequestMapping("/bookingHistory")
    public ModelAndView getProfilePage() {
    	Map<String, Reservation> model = new HashMap<String, Reservation>();
    	Set<Reservation> reservations = user.getReservations();
    	for (Reservation reservation : reservations) {
    	    model.put("reservations", reservation);
    	}
  	    modelAndView.addAllObjects(model);
        modelAndView.setViewName("bookingHistory");
        return modelAndView;
    }
    
    /**
     * <p>Once payment is done the booked ticket is show to the user</p>
     *
     * @param noOfSeatsBooked
     *     noOfSeatsBooked booked by the user
     * @param totalPrice  
     *     totalPrice for the booked tickets
     * @param paymentMode
     *     paymentMode given by the user
     *   
     * @return ModelAndView
     *     Returns ModelAndView object which is rendered with the View 'PaymentSuccess' if payment is success
     *     Returns ModelAndView object which is rendered with the View 'PaymentFailure' if payment is failed
     *     Returns ModelAndView object which is rendered with the View 'ExceptionPage' when exception occurred
     */
    @RequestMapping(value = "/payment")
    public ModelAndView getPaymentPage(@RequestParam("noOfSeatsBooked")int noOfSeatsBooked, 
 		                               @RequestParam("totalPrice") double totalPrice, 
 		                               @RequestParam("paymentMode") String paymentMode,
 		                               final HttpServletRequest request) {
 	  
      String current_user = request.getRemoteUser();
 	  boolean status = false;
 	  user = userManager.getUserByUsername(current_user);
 	  try {
 	      tripRoute = tripRouteService.getTripRouteById(tripRoute.getId());
 	  } catch (DatabaseException e) {
 		  return new ModelAndView("ExceptionPage");
 	  }
 	  
 	  if(noOfSeatsBooked > tripRoute.getTrip().getSeatVacancy()) {
 		  return new ModelAndView("ExceptionPage"); 
 	  } else {
 	      if (paymentMode.equals("Net Banking")) {
 		      return new ModelAndView("PaymentFailure");
 	      } else {
     		  status = true;
 	   	      try {
 		   	      reservation = reservationService.addReservation(user, tripRoute, noOfSeatsBooked, totalPrice, paymentMode, status);
 		   	      Map<String, Reservation> model = new HashMap<String, Reservation>();
 		   	      model.put("reservation", reservation);
 		   	      modelAndView.addAllObjects(model);
 	              modelAndView.setViewName("PaymentSuccess");
 	              return modelAndView;
 		      } catch (DatabaseException e) {
 		       	  GenericService.exceptionWriter(e);
 			      return new ModelAndView("ExceptionPage");
 		      }
 	      }     	  
 	  }
    }  
}