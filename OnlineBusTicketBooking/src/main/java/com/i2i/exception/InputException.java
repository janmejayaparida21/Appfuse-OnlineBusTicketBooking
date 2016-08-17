package com.i2i.exception;

/**
 * Customized exception which is thrown when the input given by the user is not valid
 *
 * @author Sivaranjani
 * @created 17-08-2016
 */
public class InputException extends Exception {
    public InputException () {

    }

    public InputException (String message) {
        super (message);
    }

    public InputException (Throwable cause) {
        super (cause);
    }

    public InputException (String message, Throwable cause) {
        super (message, cause);
    }
}