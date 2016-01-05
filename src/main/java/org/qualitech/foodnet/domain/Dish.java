package org.qualitech.foodnet.domain;

import javax.persistence.*;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "dish")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dish {

    private long dishId;
    private double price;
    private String name;
    private String description;
    private int categoryId;
    private Chef chef;
    private Order order;

    @ManyToOne
    @JoinColumn(name="orderId")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Id
    @GeneratedValue
    @Column(name = "dishId")
    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    @Column
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "id")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @ManyToOne
    @JoinColumn(name="chefId")
    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

}
