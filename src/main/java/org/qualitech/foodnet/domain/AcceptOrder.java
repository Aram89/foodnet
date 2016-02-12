package org.qualitech.foodnet.domain;

import javax.persistence.Column;

/**
 * @author Aram Kirakosyan.
 */
public class AcceptOrder {

    private long orderId;
    private int chefId;
    private String accessToken;
    private long duration;

    @Column
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
