package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.AcceptOrder;
import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.exception.AppException;

/**
 * @author Aram Kirakosyan.
 */
public interface OrderService {

    void makeOrder(Order order);
    void acceptOrder(AcceptOrder acceptOrder) throws AppException;
}
