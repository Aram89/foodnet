package org.qualitech.foodnet.domain;

import javax.persistence.*;

/**
 * Class for name represantation in different languages.
 *
 * @author Aram.
 */
@Entity
@Table(name = "name")
public class Name {

    /**
     * Name id.
     */
    private long nameId;

    /**
     * Name in armenian.
     */
    private String nameAM;

    /**
     * Name in russian.
     */
    private String nameRU;

    /**
     * Name in english.
     */
    private String nameENG;

    @Id
    @GeneratedValue
    @Column
    public long getNameId() {
        return nameId;
    }

    public void setNameId(long nameId) {
        this.nameId = nameId;
    }

    @Column
    public String getNameRU() {
        return nameRU;
    }

    public void setNameRU(String nameRU) {
        this.nameRU = nameRU;
    }

    @Column
    public String getNameAM() {
        return nameAM;
    }

    public void setNameAM(String nameAM) {
        this.nameAM = nameAM;
    }

    @Column
    public String getNameENG() {
        return nameENG;
    }

    public void setNameENG(String nameENG) {
        this.nameENG = nameENG;
    }

}
