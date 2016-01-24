package org.qualitech.foodnet.domain.json;

import org.qualitech.foodnet.domain.Chef;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */

public class ChefRest {

    private int chefId;
    private Short rating;
    private String feedback;
    private String name;
    private String surName;
    private String phone;
    private String status;

    public ChefRest(Chef chef) {
        this.chefId = chef.getChefId();
        this.rating = chef.getRating();
        this.feedback = chef.getFeedback();
        this.surName = chef.getSurName();
        this.phone = chef.getPhone();
        this.status = chef.getStatus();
    }

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<DishRest> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishRest> dishes) {
        this.dishes = dishes;
    }

    private String password;
    private List<DishRest> dishes;
}