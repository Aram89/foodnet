package org.qualitech.foodnet.domain;

import javax.persistence.*;

/**
 * Class for name represantation in different languages.
 *
 * @author Aram.
 */
@Entity
@Table(name = "description")
public class Description {

    private long descriptionId;

    /**
     * Description in armenian.
     */
    private String descriptionAM;

    /**
     * Description in russian.
     */
    private String descriptionRU;

    /**
     * Description in english.
     */
    private String descriptionENG;

    @Id
    @GeneratedValue
    @Column
    public long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(long descriptionId) {
        this.descriptionId = descriptionId;
    }

    @Column
    public String getDescriptionAM() {
        return descriptionAM;
    }

    public void setDescriptionAM(String descriptionAM) {
        this.descriptionAM = descriptionAM;
    }

    @Column
    public String getDescriptionRU() {
        return descriptionRU;
    }

    public void setDescriptionRU(String descriptionRU) {
        this.descriptionRU = descriptionRU;
    }

    @Column
    public String getDescriptionENG() {
        return descriptionENG;
    }

    public void setDescriptionENG(String descriptionENG) {
        this.descriptionENG = descriptionENG;
    }

}
