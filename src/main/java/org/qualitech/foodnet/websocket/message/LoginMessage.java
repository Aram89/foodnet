package org.qualitech.foodnet.websocket.message;

/**
 * @author Aram Kirakosyan.
 */
public class LoginMessage extends Message {

    Long chefId;

    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
        this.chefId = chefId;
    }
}
