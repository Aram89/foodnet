package org.qualitech.foodnet.websocket.message;

/**
 * @author Aram Kirakosyan.
 */
public class Response {

    private MessageTypes type;
    private StatusCode status;

    public MessageTypes getType() {
        return type;
    }

    public Response(MessageTypes type) {
        this.type = type;
    }

    public void setType(MessageTypes type) {
        this.type = type;
    }

    public StatusCode getStatus() {
        return status;
    }

    public void setStatus(StatusCode status) {
        this.status = status;
    }
}
