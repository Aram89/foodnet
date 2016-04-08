package org.qualitech.foodnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
public class Category implements Serializable {

    private long categoryId;
    private String name;
    private String description;

    @JsonIgnore
    private List<Dish> dishes;

    @JsonIgnore
    @ManyToMany(mappedBy="categories", fetch = FetchType.EAGER)
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Id
    @GeneratedValue
    @Column(name = "categoryId")
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
