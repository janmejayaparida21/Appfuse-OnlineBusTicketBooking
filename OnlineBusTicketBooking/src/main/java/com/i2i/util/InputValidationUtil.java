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
	public static boolean checkIfZero (int input) {
		return (input != 0);
	}
	
	/**
	 * 
	 * @param paymentMode
	 * 		paymentMode that is to be validated
	 * @return boolean
	 * 		true if input is not equal to "--Select paymentMode--"
	 * 		false if input is equal to "--Select paymentMode--"
	 */
	public static boolean checkIfPaymentModeIsValid (String paymentMode) {
		return (!(paymentMode.equals("--Select paymentMode--")));
	}
}