package org.qualitech.foodnet.exception;

/**
 * Exception class for throwing exceptions from application.
 *
 * @author Aram Kirakosyan.
 */
public class AppException extends Exception{

    public AppException(String error) {
        super(error);
    }
}


