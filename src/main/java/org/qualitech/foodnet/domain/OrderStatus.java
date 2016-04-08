package org.qualitech.foodnet.domain;

/**
 * @author Aram Kirakosyan.
 */
public enum OrderStatus {

    // Order was done, not accepted by client yet, we will call.
    WAITING("WAITING"),

    // Order accepted by client by phone.
    ACCEPTED_BY_CLIENT("ACCEPTED_BY_CLIENT"),

    // Order was sent to chef, not accepted yet.
    SENT_TO_CHEF("SENT_TO_CHEF"),

    // Order accepted by chef.
    ACCEPTED_BY_CHEF("ACCEPTED_BY_CHEF"),

    // Order was sent to courier, not accepted yet.
    SENT_TO_COURIER("SENT_TO_COURIER"),
    // Order accepted by courier.

    ACCEPTED_BY_COURIER("ACCEPTED_BY_COURIER"),
    // Order completed by chef.

    COMPLETED_BY_CHEF("COMPLETED_BY_CHEF"),
    // Order Completed by courier..

    COMPLETED_BY_COURIER("COMPLETED_BY_COURIER"),

    // Order completed.
    COMPLETED("COMPLETED");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
