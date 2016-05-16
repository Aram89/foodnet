package org.qualitech.foodnet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qualitech.foodnet.domain.json.AcceptOrder;
import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    // Logger.
    private  static Logger logger = LogManager.getLogger(OrderController.class);


    /**
     * Endpoint for making order.
     *
     * @param order order.
     * @return status ok, if order was done.
     * @throws AppException
     */
    @RequestMapping(value = RequestMappings.MAKE_ORDER, method = RequestMethod.POST)
    public ResponseEntity makeOrder(@RequestBody Order order) throws AppException, IOException {
        orderService.makeOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.COURIER_ACCEPT_ORDER, method = RequestMethod.POST)
    public ResponseEntity acceptOrderCourier(@RequestBody String decodedString) throws AppException, IOException {
        AcceptOrder acceptOrder = convert(decodedString);
        logger.info("accept order request for order " + acceptOrder + "Courier :" + acceptOrder.getPartnerId());
        orderService.acceptOrderByCourier(acceptOrder);
        logger.info("order accepted");
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = RequestMappings.ACCEPT_ORDER, method = RequestMethod.POST)
    public ResponseEntity acceptOrder(@RequestBody String decodedString) throws AppException, IOException {
        AcceptOrder acceptOrder = convert(decodedString);
        logger.info("accept order request for order " + acceptOrder);
        orderService.acceptOrderByChef(acceptOrder);
        logger.info("order accepted");
        return new ResponseEntity(HttpStatus.OK);
    }

    private AcceptOrder convert(String decodedString) throws IOException {
        String acceptOrderString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        AcceptOrder acceptOrder = mapper.readValue(acceptOrderString, AcceptOrder.class);
        return acceptOrder;
    }

    @RequestMapping(value = RequestMappings.ADMIN, method = RequestMethod.GET)
    public String admin() {
        return RequestMappings.ADMIN;
    }

}
