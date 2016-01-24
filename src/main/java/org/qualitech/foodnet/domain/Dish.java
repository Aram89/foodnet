package org.qualitech.foodnet.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "dish")
public class Dish {

    private long dishId;
    private double price;
    private String name;
    private String description;
    private Chef chef;
    private Order order;
    private List <Category> categories;
    private List<File> files;

    @OneToMany
    @JoinColumn(name="dishId")
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "dishCategory", joinColumns = {
            @JoinColumn(name = "dishId", insertable = false) },
            inverseJoinColumns = { @JoinColumn(name = "categoryId", insertable = false) })
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @ManyToOne
    @JoinColumn(name="ordersId")
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


    @ManyToOne
    @JoinColumn(name="chefId")
    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

}
