package org.qualitech.foodnet.websocket;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.qualitech.foodnet.repositories.ChefRepository;
import org.qualitech.foodnet.service.ChefService;
import org.qualitech.foodnet.websocket.message.LoginMessage;
import org.qualitech.foodnet.websocket.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.*;
import java.io.IOException;
import java.util.Map;

/**
 * @author Aram Kirakosyan.
 */
@Component
@ServerEndpoint(value = "/chef")
public class ChefEndpoint {

    @Autowired
    ChefService service;

    private Map <Long, String> userIds;

    private void login(LoginMessage loginMessage, Session session) {
        long id = loginMessage.getChefId();
        String accessToken = loginMessage.getAccessToken();
        if(service.checkAccessToken(id, accessToken)){
            userIds.put(id, session.getId());
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println();
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        Message msg = mapper.readValue(message, Message.class);
        switch (mapper.readValue(message, Message.class).getType()) {
            case LOGIN :
                login(mapper.readValue(message, LoginMessage.class), session);
            case ACCEPT:
                // TODO
            default:
                // TODO.
        }
    }

    @OnClose
    public void onClose (CloseReason reason) {
        System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
    }


}