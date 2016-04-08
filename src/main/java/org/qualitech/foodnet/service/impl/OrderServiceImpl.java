package org.qualitech.foodnet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.qualitech.foodnet.domain.*;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.*;
import org.qualitech.foodnet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @author Aram Kirakosyan..
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final static int deliveryPay = 400;

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private DishOrderRepository dishOrderRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ChefRepository chefRepository;

    @Override
    public void makeOrder(Order order) throws AppException, IOException {
        // Client not accepted order yet, will be changed after calling to client.
        order.setClientStatus(OrderStatus.WAITING);

        // TODO REMOVE, it will be set from admin panel after calling to client
        order.setOrderStatus(OrderStatus.ACCEPTED_BY_CLIENT);
        for(DishOrder d : order.getDishOrders()) {
            d.setOrder(order);
        }
        long chefId = validateOrder(order);
        order.setChefId(chefId);
        orderRepository.save(order);
    }

    @Override
    public void acceptOrderByChef(AcceptOrder acceptOrder) throws AppException {
        // Check permission.
        if(chefRepository.getByPartnerIdAndAccessToken(acceptOrder.getPartnerId(), acceptOrder.getAccessToken()).isEmpty()) {
            throw new AppException(ErrorCodes.PERMISSION_DENIED);
        }
        //TODO Check if the chef is order owner
        orderRepository.updateOrderStatus(acceptOrder.getOrdersId(), OrderStatus.ACCEPTED_BY_CHEF);
    }

    @Override
    public void acceptOrderByCourier(AcceptOrder acceptOrder) throws AppException {
        // Check permission.
        if(courierRepository.getByPartnerIdAndAccessToken(acceptOrder.getPartnerId(), acceptOrder.getAccessToken()).isEmpty()) {
            throw new AppException(ErrorCodes.PERMISSION_DENIED);
        }
        //TODO Check if the chef is order owner
        orderRepository.updateOrderStatus(acceptOrder.getOrdersId(), OrderStatus.ACCEPTED_BY_COURIER);
    }


    @Override
    public String getOrders(Long chefId) throws AppException, IOException {
        List<Order> orders = orderRepository.findByChefIdAndOrderStatus(chefId, OrderStatus.ACCEPTED_BY_CLIENT);
        for (Order order : orders) {
            List<DishOrder> dishOrders = dishOrderRepository.findByOrder(order);
            order.setDishOrders(dishOrders);
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(orders);

        // Everything is OK, update order status to PENDING.
        for(Order order : orders) {
            orderRepository.updateOrderStatus(order.getOrdersId(), OrderStatus.SENT_TO_CHEF);
        }
        return jsonResponse;
    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatus orderStatus) {
        orderRepository.updateOrderStatus(orderId, orderStatus);
    }

    private long validateOrder(Order order) throws AppException {
        // Calculate order sum
        double sum = deliveryPay;
        long currChefId = 0;
        long previousChefId = 0;
        for (DishOrder dor : order.getDishOrders()) {
            Dish dish = dor.getDish();
            sum += dish.getPrice();
            currChefId = dishRepository.findChefByDishId(dish.getDishId()).get(0).getChef().getPartnerId();
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
