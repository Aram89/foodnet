package org.qualitech.foodnet.domain;

import org.qualitech.foodnet.domain.json.OrderStatus;

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
    private Integer price;
    private Integer chefPrice;
    private Date completedByChefTime;
    private Date acceptedByChefTime;

    @Column
    public Date getAcceptedByCourierTime() {
        return acceptedByCourierTime;
    }

    public void setAcceptedByCourierTime(Date acceptedByCourierTime) {
        this.acceptedByCourierTime = acceptedByCourierTime;
    }

    @Column
    public Date getAcceptedByChefTime() {
        return acceptedByChefTime;
    }

    public void setAcceptedByChefTime(Date acceptedByChefTime) {
        this.acceptedByChefTime = acceptedByChefTime;
    }

    private Date acceptedByCourierTime;

    @Column
    public Date getCompletedByChefTime() {
        return completedByChefTime;
    }

    public void setCompletedByChefTime(Date completedByChefTime) {
        this.completedByChefTime = completedByChefTime;
    }

    private String phone;
    private String comment;
    private OrderStatus orderStatus;
    private Long chefId;
    private OrderStatus PartnerStatus;
    private OrderStatus courierStatus;
    private OrderStatus clientStatus;
    private String location;
    private String orderDeliveryDate;
    private String orderDate;

    @Column
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Column
    public String getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    public void setOrderDeliveryDate(String orderDeliveryDate) {
        this.orderDeliveryDate = orderDeliveryDate;
    }

    @Column
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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


    @OneToMany (mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
    public Integer getPrice() {
        return price;
    }

    @Column
    public Integer getChefPrice() {
        return chefPrice;
    }

    public void setChefPrice(Integer chefPrice) {
        this.chefPrice = chefPrice;
    }

    public void setPrice(Integer price) {
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
