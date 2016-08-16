package com.i2i.exception;

/**
 * User defined exception which is thrown when there is exception thrown by database.
 *
 * @author  Shrie Satheyaa
 *
 * @created   2016-07-25
 */
public class DatabaseException extends Exception {
    public DatabaseException () {

    }

    public DatabaseException (String message) {
        super (message);
    }

    public DatabaseException (Throwable cause) {
        super (cause);
    }

    public DatabaseException (String message, Throwable cause) {
        super (message, cause);
    }
}