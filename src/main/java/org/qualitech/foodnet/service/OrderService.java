package org.qualitech.foodnet.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.qualitech.foodnet.domain.json.AcceptOrder;
import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.domain.json.OrderStatus;
import org.qualitech.foodnet.exception.AppException;

import java.io.IOException;

/**
 * @author Aram Kirakosyan.
 */
public interface OrderService {

    void makeOrder(Order order) throws AppException, IOException;
    void acceptOrderByChef(AcceptOrder acceptOrder) throws AppException;
    String getOrders(Long chefId) throws AppException, IOException;
    String getCourierOrders(Long courierId) throws AppException, JsonProcessingException;
    void updateOrderStatus(Long orderId, OrderStatus orderStatus);
    void acceptOrderByCourier(AcceptOrder acceptOrder) throws AppException;
}
