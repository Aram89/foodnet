package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.AcceptOrder;
import org.qualitech.foodnet.domain.DishOrder;
import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.domain.OrderStatus;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.ChefRepository;
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
    OrderRepository orderRepository;

    @Autowired
    ChefRepository chefRepository;

    @Override
    public void makeOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        for(DishOrder d : order.getDishOrders()) {
            d.setOrder(order);
        }
        orderRepository.save(order);
    }

    @Override
    public void acceptOrder(AcceptOrder acceptOrder) throws AppException {
        // Check permission.
        if(chefRepository.getByChefIdAndAccessToken(acceptOrder.getChefId(), acceptOrder.getAccessToken()).isEmpty()) {
            throw new AppException(ErrorCodes.PERMISSION_DENIED);
        }
        //TODO Check if the chef is order owner
        orderRepository.updateOrderStatus(acceptOrder.getOrderId(), OrderStatus.ACCEPTED);

    }
}
