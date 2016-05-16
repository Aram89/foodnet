package org.qualitech.foodnet.domain.json;

import java.util.Date;

/**
 * @author Aram Kirakosyan.
 */
public class CourierOrder {

    private Long ordersId;

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    private String from;
    private String to;
    private Integer chefPrice;
    private Integer totalPrice;
    private Integer deliveryPay;
    private String chefPhone;
    private String clientPhone;
    private String time;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getChefPrice() {
        return chefPrice;
    }

    public void setChefPrice(Integer chefPrice) {
        this.chefPrice = chefPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getDeliveryPay() {
        return deliveryPay;
    }

    public void setDeliveryPay(Integer deliveryPay) {
        this.deliveryPay = deliveryPay;
    }

    public String getChefPhone() {
        return chefPhone;
    }

    public void setChefPhone(String chefPhone) {
        this.chefPhone = chefPhone;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
}
