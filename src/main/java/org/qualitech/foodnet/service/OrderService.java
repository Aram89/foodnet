package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.AcceptOrder;
import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.domain.OrderStatus;
import org.qualitech.foodnet.exception.AppException;

import java.io.IOException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface OrderService {

    void makeOrder(Order order) throws AppException, IOException;
    void acceptOrderByChef(AcceptOrder acceptOrder) throws AppException;
    String getOrders(Long chefId) throws AppException, IOException;
    void updateOrderStatus(Long orderId, OrderStatus orderStatus);
    void acceptOrderByCourier(AcceptOrder acceptOrder) throws AppException;
}
