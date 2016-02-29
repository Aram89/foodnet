package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.AcceptOrder;
import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.exception.AppException;

import java.io.IOException;

/**
 * @author Aram Kirakosyan.
 */
public interface OrderService {

    void makeOrder(Order order) throws AppException, IOException;
    void acceptOrder(AcceptOrder acceptOrder) throws AppException;
}
