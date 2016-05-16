package org.qualitech.foodnet.domain.json;

/**
 * Created by Aram on 4/3/2016.
 */
public enum  WorkSchedule {

    FREE("free"),
    FIXED("fixed");

    private String value;

    WorkSchedule(String value) {
        this.value = value;
    }
}
