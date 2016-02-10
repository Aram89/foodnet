package org.qualitech.foodnet.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable{

    private long orderId;
    private Date time;
    private double price;
    private String phone;
    private List<DishOrder> dishOrders;

    @OneToMany (mappedBy = "order", cascade = CascadeType.PERSIST)
    public List<DishOrder> getDishOrders() {
        return dishOrders;
    }

    public void setDishOrders(List<DishOrder> dishOrders) {
        this.dishOrders = dishOrders;
    }

    @Id
    @GeneratedValue
    @Column(name = "ordersId")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Column
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Column
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
