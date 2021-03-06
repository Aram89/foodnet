package org.qualitech.foodnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author Aram Kirakosyan.
 */
@Entity
public class DishOrder {

    private long id;
    private int count;
    private Dish dish;
    private Order order;


    @Column
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dishId")
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ordersId", insertable = true, updatable = true)
    public Order getOrder() {
        return order;
    }

    @JsonIgnore
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return dish + ", count = " + count;
    }
}
