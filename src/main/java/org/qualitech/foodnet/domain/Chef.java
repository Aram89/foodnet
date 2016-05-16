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


    public Chef() {
    }

    public Chef(Long chefId) {
        super(chefId);
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="partnerId")
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }


}
