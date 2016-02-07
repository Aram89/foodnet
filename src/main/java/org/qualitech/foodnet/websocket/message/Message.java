package org.qualitech.foodnet.websocket.message;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Aram Kirakosyan.
 */
@JsonIgnoreProperties
public class Message {

    private MessageTypes type;
    private String accessToken;

    public MessageTypes getType() {
        return type;
    }

    public void setType(MessageTypes type) {
        this.type = type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
