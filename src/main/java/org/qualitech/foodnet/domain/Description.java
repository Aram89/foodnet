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
    private String am;

    /**
     * Description in russian.
     */
    private String ru;

    /**
     * Description in english.
     */
    private String en;

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
    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    @Column
    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    @Column
    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
