package org.qualitech.foodnet.domain;

/**
 * Created by Aram on 4/3/2016.
 */
public enum  WorkStatus {
    ONLINE("Online"),
    OFFLINE("Offline");

    private String value;

    WorkStatus(String value) {
        this.value = value;
    }
}
