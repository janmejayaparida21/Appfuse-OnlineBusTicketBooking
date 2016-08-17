package com.i2i.util;

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
}