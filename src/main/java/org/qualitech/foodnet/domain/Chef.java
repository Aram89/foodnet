package org.qualitech.foodnet.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "chef")
@Inheritance(strategy = InheritanceType.JOINED)
public class Chef {

    private int chefId;
    private short rating;
    private String feedback;
    private String name;
    private String surName;
    private String phone;
    private String status;
    private List <Dish> dishes;

    @Id
    @GeneratedValue
    @Column(name = "chefId")
    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    @Column
    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    @Column
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "chef")
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
