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
    private OrderStatus orderStatus;
    private Long chefId;
    private OrderStatus PartnerStatus;
    private OrderStatus courierStatus;
    private OrderStatus clientStatus;

    @Enumerated(EnumType.STRING)
    @Column
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Enumerated(EnumType.STRING)
    @Column
    public OrderStatus getPartnerStatus() {
        return PartnerStatus;
    }

    public void setPartnerStatus(OrderStatus PartnerStatus) {
        this.PartnerStatus = PartnerStatus;
    }

    @Enumerated(EnumType.STRING)
    @Column
    public OrderStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(OrderStatus courierStatus) {
        this.courierStatus = courierStatus;
    }

    @Enumerated(EnumType.STRING)
    @Column
    public OrderStatus getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(OrderStatus clientStatus) {
        this.clientStatus = clientStatus;
    }

    @Column
    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
        this.chefId = chefId;
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

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", comment='" + comment + '\'' +
                ", dishOrders=" + dishOrders +
                '}';
    }

}
