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
    public static final String PERMISSION_DENIED = "permission denied";
    public static final String WRONG_ORDER_PRICE = "Gyada es inch muxlyojner es anum?";
    public static final String MULTIPLE_CHEFS_IN_ORDER = "Multiple chefs in one order request";
    public static final String INACTIVE_ACCOUNT = "Your account was not activated";
    public static final String WRONG_ACCESS_TOKEN = "Wrong access token";
    public static final String WRONG_CHEF_IN_ORDER = "Wrong chef in order";


    private String errorString;

    public ErrorCodes(String errorString) {
        this.errorString = errorString;
    }
}
