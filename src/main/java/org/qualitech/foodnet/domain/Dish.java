package org.qualitech.foodnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "dish")
public class Dish implements Serializable  {

    private long dishId;
    private double price;
    private String name;
    private String description;
    private Chef chef;
    private List <Category> categories;
    private List<File> files;
    private List<Order> orders;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name="dishOrder",
            joinColumns={@JoinColumn(name="dishId", referencedColumnName="dishId")},
            inverseJoinColumns={@JoinColumn(name="ordersId", referencedColumnName="ordersId")})
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="dishId")
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "dishCategory", joinColumns = {
            @JoinColumn(name = "dishId", insertable = false) },
            inverseJoinColumns = { @JoinColumn(name = "categoryId", insertable = false) })
    public List<Category> getCategories() {
        return categories;
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

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="chefId")
    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

}
