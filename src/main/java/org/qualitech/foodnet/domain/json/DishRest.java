package org.qualitech.foodnet.domain.json;

import org.qualitech.foodnet.domain.Dish;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public class DishRest {

    private long dishId;
    private double price;
    private String name;
    private String description;
    private ChefRest chef;
    private OrderRest order;
    private List <CategoryRest> categories;
    private List<FileRest> files;

    public DishRest(Dish dish) {
        this.dishId = dish.getDishId();
        this.price = dish.getPrice();
        this.name = dish.getName();
        this.description = dish.getDescription();
    }

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public ChefRest getChef() {
        return chef;
    }

    public void setChef(ChefRest chef) {
        this.chef = chef;
    }

    public OrderRest getOrder() {
        return order;
    }

    public void setOrder(OrderRest order) {
        this.order = order;
    }

    public List<CategoryRest> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryRest> categories) {
        this.categories = categories;
    }

    public List<FileRest> getFiles() {
        return files;
    }

    public void setFiles(List<FileRest> files) {
        this.files = files;
    }


}
