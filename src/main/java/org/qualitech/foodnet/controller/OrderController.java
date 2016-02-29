package org.qualitech.foodnet.controller;

import org.qualitech.foodnet.domain.AcceptOrder;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

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

    @RequestMapping(value = RequestMappings.ACCEPT_ORDER, method = RequestMethod.POST)
    public ResponseEntity makeOrder(@RequestBody AcceptOrder acceptOrder) throws AppException {
        orderService.acceptOrder(acceptOrder);
        return new ResponseEntity(HttpStatus.OK);
    }
}
