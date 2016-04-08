package org.qualitech.foodnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@DiscriminatorValue("chef")
public class Chef  extends Partner {

    private List<File> files;
    private String location;

    public Chef() {
    }

    public Chef(Long chefId) {
        super(chefId);
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="chefId")
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Column
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
