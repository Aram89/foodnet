package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Aram Kirakosyan..
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Override
    public void makeOrder(Order order) {
        repository.save(order);
    }
}
