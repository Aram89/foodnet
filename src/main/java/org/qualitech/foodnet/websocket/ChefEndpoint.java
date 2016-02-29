package org.qualitech.foodnet.websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.service.ChefService;
import org.qualitech.foodnet.websocket.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aram Kirakosyan.
 */
@Component
@ServerEndpoint(value = "/chef")
public class ChefEndpoint {

    // Logger.
    private  static Logger logger = LogManager.getLogger(ChefEndpoint.class);

    @Autowired
    ChefService service;

    private Map <Long, Session> sessions = new HashMap<Long, Session>();

    private void login(LoginMessage loginMessage, Session session) throws IOException, EncodeException {
        long id = loginMessage.getChefId();
        String accessToken = loginMessage.getAccessToken();
        Response response = new Response(MessageTypes.LOGIN);
        ObjectMapper mapper = new ObjectMapper();
        if(service.checkAccessToken(id, accessToken)){
            sessions.put(id, session);
            response.setStatus(StatusCode.OK);
        } else {
            response.setStatus(StatusCode.FAIL);
        }
        String jsonResponse = mapper.writeValueAsString(response);
        session.getBasicRemote().sendText(jsonResponse);
    }

    @OnOpen
    public void onOpen(Session session) throws IOException {
        logger.info("New Session opened " + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException, EncodeException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        Message msg = mapper.readValue(message, Message.class);
        switch (msg.getType()) {
            case LOGIN :
                logger.info("Websocket login message " + msg);
                login(mapper.readValue(message, LoginMessage.class), session);
                break;
            default:
                // TODO.
        }
    }

    @OnClose
    public void onClose (CloseReason reason) {
        logger.info("Closing a WebSocket due to " + reason.getReasonPhrase());
    }

    /**
     * Send order to Chef.
     *
     * @param chefId chefId.
     * @param order order.
     * @throws IOException
     */
    public void sendOrder(long chefId, Order order) throws IOException {
        if (sessions.containsKey(chefId)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValueAsString(order);
            Session session = sessions.get(chefId);
            session.getBasicRemote().sendText(order.toString());
        } else {
            // TODO
        }
    }


}