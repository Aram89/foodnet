package org.qualitech.foodnet.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Aram Kirakosyan.
 */
@Entity
@DiscriminatorValue("partner")
public class Courier extends Partner {

    public Courier(Long courierId) {
        super(courierId);
    }
}
