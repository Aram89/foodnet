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

    private long ordersId;
    private Date time;
    private double price;
    private String phone;
    private String comment;
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    @Column
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    private List<DishOrder> dishOrders;

    @Column
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @OneToMany (mappedBy = "order", cascade = CascadeType.ALL)
    public List<DishOrder> getDishOrders() {
        return dishOrders;
    }

    public void setDishOrders(List<DishOrder> dishOrders) {
        this.dishOrders = dishOrders;
    }

    @Id
    @GeneratedValue
    @Column(name = "ordersId")
    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
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
