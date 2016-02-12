package org.qualitech.foodnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "chef")
public class Chef implements Serializable {

    public Chef() {
    }

    public Chef(Integer chefId) {
        this.chefId = chefId;
    }

    private long chefId;
    private Short rating;
    private String feedback;
    private String name;
    private String surName;
    private String phone;
    private String password;
    private String accessToken;
    private ChefStatus status;
    private List<File> files;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="chefId")
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Column
    public ChefStatus getStatus() {
        return status;
    }

    @JsonIgnore
    public void setStatus(ChefStatus status) {
        this.status = status;
    }

    @Column
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getAccessToken() {
        return accessToken;
    }

    @JsonIgnore
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Id
    @GeneratedValue
    @Column(name = "chefId")
    public Long getChefId() {
        return chefId;
    }

    public void setChefId(long chefId) {
        this.chefId = chefId;
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
    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

}
