package com.i2i.util;

import java.util.Date;

/**
 * <p>
 * InputValidationUtil Helper class for performing custom validations.
 * </p>
 * 
 * @author Ideas2IT-Sivaranjani
 * @Created 17-08-2016
 */
public class InputValidationUtil {
	
	/**
	 * <p>
	 * Checks whether the given input is Zero or not
	 * </p>
	 * 
	 * @param input
	 *		input that is to be validated
	 * @return boolean
	 * 		true if input is not zero
	 * 		false if input is zero
	 */
	public static boolean checkIfNotZero (int input) {
		return (input > 0);
	}
	
	/**
	 * <p>
	 * Checks if payment mode is valid
	 * </p>
	 * 
	 * @param paymentMode
	 * 		paymentMode that is to be validated
	 * @return boolean
	 * 		true if paymentMode is not equal to "--Select paymentMode--"
	 * 		false if paymentMode is equal to "--Select paymentMode--"
	 */
	public static boolean checkIfPaymentModeIsValid (String paymentMode) {System.out.println("CHECKING MODE");
		return (!(paymentMode.equals("--Select paymentMode--")));
	}
	
	/**
	 * <p>
	 * Checks if NoOfSeatsBooked is valid
	 * 
	 * @param noOfSeatsBooked
	 * 		noOfSeatsBooked that is to be validated
	 * @return boolean
	 * 		true if noOfSeatsBooked is lesser than available seats
	 * 		false if noOfSeatsBooked is graeter than available seats
	 */
	public static boolean checkIfNoOfSeatsBookedIsValid (int noOfSeatsBooked, int availableSeats) {
		return (noOfSeatsBooked <= availableSeats);
	}
	
	/**
	 * <p>
	 * Checks if payment mode is NetBanking
	 * </p>
	 * 
	 * @param paymentMode
	 * 		paymentMode that is to be validated
	 * @return boolean
	 * 		true if paymentMode is equal to "Net Banking"
	 * 		false if paymentMode is not equal to "Net Banking"
	 */
	public static boolean checkIfNetBanking (String paymentMode){
		return (paymentMode.equals("Net Banking"));
	}
	
   /** 
	 * <p>
	 * Checks whether the source and destination same or not. 
	 * </p>
	 * @param sourceCityName 
     *     Source city of the route which  is to be validated 
     * 
     * @param destinationCityName 
     *     Destination city of the route which is to be validated. 
     *     
	 * @return boolean
	 * 		true if sourceCityName is  not equal to destinationCityName
	 * 		false if sourceCityName is equal to destinationCityName
	 */
	public static boolean checkIfSourceDestinationSame (String sourceCityName, String destinationCityName) {
		return (!(sourceCityName.equals(destinationCityName)));
	}
	
	/**
	 * 
	 * <p>
	 * Checks whether the source is empty. 
	 * </p>
	 * @param sourceCityName 
     *     Source city of the route which is to be validated. 
     * 
	 * @return boolean
	 * 		true if sourceCityName is  not equal to "--Select Source--"
	 * 		false if sourceCityName is  equal to "--Select Source--"
	 */
	public static boolean checkIfSourceEmpty (String sourceCityName) {
		return (!(sourceCityName.equals("--Select Source--")));
	}
	
	/**
	 * 
	 * <p>
	 * Checks whether the destination is empty. 
	 * </p>
	 * @param destinationCityName 
     *     destination city of the route which is to be validated. 
     * 
	 * @return boolean
	 * 		true if destinationCityName is  not equal to "--Select Destination--"
	 * 		false if destinationCityName is  equal to "--Select Destination--"
	 */
	public static boolean checkIfDestinationEmpty (String destinationCityName) {
		return (!(destinationCityName.equals("--Select Destination--")));
	}
	
	/**
	 * 
	 * <p>
	 * Checks whether the date of travel is not past date. 
	 * </p>
	 * @param Date
     *     Travel date  
     * 
	 * @return boolean
	 * 		true if dateOfTravel is not past date
	 * 		false if dateOfTravel is past date
	 */
	public static boolean checkIfDateValid (Date dateOfTravel) {
		Date todayDate = new Date();
		return (dateOfTravel.getTime() > todayDate.getTime());
	}
	
}