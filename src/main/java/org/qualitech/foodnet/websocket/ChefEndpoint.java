package org.qualitech.foodnet.websocket;

import javax.websocket.*;
import javax.websocket.server.*;
import java.util.Map;

/**
 * @author Aram Kirakosyan.
 */
@ServerEndpoint(value = "/chef")
public class ChefEndpoint {

    private Map<Long, Long> userIds;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println();
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println(message);
    }

    @OnClose
    public void myOnClose (CloseReason reason) {
        System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
    }


}
