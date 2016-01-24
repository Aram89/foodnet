package org.qualitech.foodnet.domain.json;

import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */

public class OrderRest {

    private long orderId;
    private Date time;
    private double price;
    private String location;
    private List<DishRest> dishes;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<DishRest> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishRest> dishes) {
        this.dishes = dishes;
    }
}
