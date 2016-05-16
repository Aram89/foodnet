package org.qualitech.foodnet.domain.json;

/**
 * @author Aram Kirakosyan.
 */
public enum DishStatus {

    ACTIVE("Active"),
    INACTIVE("InActive"),
    DELETED("Deleted");

    private String value;

    DishStatus(String value) {
        this.value = value;
    }
}
