package org.qualitech.foodnet.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "order")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order {

    private long orderId;
    private Date time;
    private double price;
    private String location;
    private List <Dish> dishes;

    @Id
    @GeneratedValue
    @Column(name = "orderId")
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
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "order")
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
