package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.*;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.ChefRepository;
import org.qualitech.foodnet.repositories.DishRepository;
import org.qualitech.foodnet.repositories.OrderRepository;
import org.qualitech.foodnet.websocket.ChefEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author Aram Kirakosyan..
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final static int deliveryPay = 400;

    @Autowired
    private ChefEndpoint chefEndpoint;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ChefRepository chefRepository;

    @Override
    public void makeOrder(Order order) throws AppException, IOException {
        order.setStatus(OrderStatus.PENDING);
        for(DishOrder d : order.getDishOrders()) {
            d.setOrder(order);
        }
        long chefId = validateOrder(order);
        orderRepository.save(order);
        // Everything is OK, send order to chef.
        chefEndpoint.sendOrder(chefId, order);
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

    private long validateOrder(Order order) throws AppException {
        // Calculate order sum
        double sum = deliveryPay;
        long currChefId = 0;
        long previousChefId = 0;
        for (DishOrder dor : order.getDishOrders()) {
            Dish dish = dor.getDish();
            sum += dish.getPrice();
            currChefId = dishRepository.findChefByDishId(dish.getDishId()).get(0).getChef().getChefId();
            if (previousChefId != 0 && currChefId != previousChefId) {
                throw new AppException(ErrorCodes.MULTIPLE_CHEFS_IN_ORDER);
            }
            previousChefId = currChefId;
        }

        if (sum != order.getPrice()) {
            throw new AppException(ErrorCodes.WRONG_ORDER_PRICE);
        }
        return currChefId;
    }
}
