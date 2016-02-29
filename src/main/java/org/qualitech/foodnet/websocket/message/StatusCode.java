package org.qualitech.foodnet.websocket.message;

/**
 * @author Aram Kirakosyan.
 */
public enum StatusCode {

    OK("OK"),
    FAIL("FAIL");


    StatusCode(String status) {
        this.status = status;
    }

    private String status;

}
