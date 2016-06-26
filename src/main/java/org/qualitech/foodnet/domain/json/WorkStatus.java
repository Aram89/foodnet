package org.qualitech.foodnet.domain.json;

/**
 * @author Aram Kirakosyan.
 */
public enum  WorkStatus {
    ONLINE("Online"),
    OFFLINE("Offline");

    private String value;

    WorkStatus(String value) {
        this.value = value;
    }
}
