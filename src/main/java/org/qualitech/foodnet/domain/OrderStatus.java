package org.qualitech.foodnet.domain;

/**
 * @author Aram Kirakosyan.
 */
public enum OrderStatus {
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED"),
    COMPLETED("COMPLETED");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
