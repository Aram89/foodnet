package org.qualitech.foodnet.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
public class Category {

    private long categoryId;
    private String name;
    private String description;
    private List<Dish> dishes;

    @ManyToMany(mappedBy="categories")
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
