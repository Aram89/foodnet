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
    private String hy;

    /**
     * Name in russian.
     */
    private String ru;

    /**
     * Name in english.
     */
    private String en;

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
    public String getHy() {
        return hy;
    }

    public void setHy(String hy) {
        this.hy = hy;
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
