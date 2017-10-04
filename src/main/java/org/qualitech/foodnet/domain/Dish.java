package org.qualitech.foodnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.qualitech.foodnet.domain.json.DishStatus;

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
    private Integer price;
    private Double prepareTime;
    private Integer chefPrice;
    private Name name;
    private Description description;
    private Chef chef;
    private DishStatus dishStatus;
    private Integer rating;
    private List <Category> categories;
    private List<File> files;
    private List<Order> orders;
    private String dishName;

    @Column
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Enumerated(EnumType.STRING)
    @Column
    public DishStatus getDishStatus() {
        return dishStatus;
    }

    public void setDishStatus(DishStatus dishStatus) {
        this.dishStatus = dishStatus;
    }

    @Column
    public Double getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Double prepareTime) {
        this.prepareTime = prepareTime;
    }

    @Column
    public Integer getChefPrice() {
        return chefPrice;
    }

    public void setChefPrice(Integer chefPrice) {
        this.chefPrice = chefPrice;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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
            @JoinColumn(name = "dishId", insertable = true) },
            inverseJoinColumns = { @JoinColumn(name = "categoryId", insertable = true) })
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
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @OneToOne
    @JoinColumn(name="nameId")
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name="descriptionId")
    public Description getDescription() {
        return description;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="partnerId")
    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    @Override
    public String toString() {
        return "name = " + name;
    }


}
