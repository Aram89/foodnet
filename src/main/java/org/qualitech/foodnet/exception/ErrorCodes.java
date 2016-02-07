package org.qualitech.foodnet.exception;

/**
 * Model for error representations.
 *
 * @author Aram Kirakosyan.
 */
public class ErrorCodes {

    public static final String PHONE_EXISTS = "phoneExists";
    public static final String WRONG_USER_NAME = "wrongUserName";
    public static final String WRONG_PASSWORD = "wrongPassword";
    public static final String EMPTY_FILE = "emptyFile";
    public static final String WRONG_CATEGORY = "wrong category : ";
    public static final String WRONG_PHONE = "wrong phone";


    private String errorString;

    public ErrorCodes(String errorString) {
        this.errorString = errorString;
    }
}
