package org.qualitech.foodnet.domain.json;


import org.qualitech.foodnet.domain.Category;

import javax.persistence.*;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public class CategoryRest {

    private long categoryId;
    private String name;
    private String description;

    public CategoryRest(Category category) {
        this.categoryId = category.getCategoryId();
        this.name = category.getName();
        this.description = category.getDescription();
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DishRest> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishRest> dishes) {
        this.dishes = dishes;
    }

    private List<DishRest> dishes;


}
