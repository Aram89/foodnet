package org.qualitech.foodnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@Table(name = "partner")
@Inheritance
@DiscriminatorColumn(name="type")
public class Partner {
    public Partner() {
    }

    private Long partnerId;

    public Partner(Long partnerId) {
        this.partnerId = partnerId;
    }

    private Short rating;
    private String feedback;
    private String name;
    private String surName;
    private String phone;
    private String password;
    private String accessToken;
    private PartnerStatus status;
    private WorkStatus workStatus;
    private Date workStatusUpdateTime;
    private WorkSchedule workSchedule;

    @Id
    @GeneratedValue
    @Column
    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    @Column
    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Column
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    public PartnerStatus getStatus() {
        return status;
    }

    public void setStatus(PartnerStatus status) {
        this.status = status;
    }

    @Column
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    @Column
    public Date getWorkStatusUpdateTime() {
        return workStatusUpdateTime;
    }

    public void setWorkStatusUpdateTime(Date workStatusUpdateTime) {
        this.workStatusUpdateTime = workStatusUpdateTime;
    }

    @Column
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
    }
}
