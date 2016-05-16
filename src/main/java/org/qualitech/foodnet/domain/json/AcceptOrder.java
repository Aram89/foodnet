package org.qualitech.foodnet.domain.json;

import javax.persistence.Column;

/**
 * @author Aram Kirakosyan.
 */
public class AcceptOrder {

    public Long getPartnerId() {
        return partnerId;
    }

    @Override
    public String toString() {
        return "AcceptOrder{" +
                "ordersId=" + ordersId +
                ", partnerId=" + partnerId +
                ", accessToken='" + accessToken + '\'' +
                ", duration=" + duration +
                '}';
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    private long ordersId;

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

    private Long partnerId;
    private String accessToken;

    private long duration;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
