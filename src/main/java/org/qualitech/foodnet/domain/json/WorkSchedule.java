package org.qualitech.foodnet.domain.json;

/**
 * @author Aram Kirakosyan.
 */
public enum  WorkSchedule {

    FREE("free"),
    FIXED("fixed");

    private String value;

    WorkSchedule(String value) {
        this.value = value;
    }
}
