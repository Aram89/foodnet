package org.qualitech.foodnet.exception;

/**
 * @author Aram Kirakosyan.
 */
public class UnAuthorizedException extends RuntimeException {

    public UnAuthorizedException(String error) {
        super(error);
    }
}
