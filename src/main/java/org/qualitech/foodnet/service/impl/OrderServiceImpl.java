package org.qualitech.foodnet.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.qualitech.foodnet.domain.*;
import org.qualitech.foodnet.domain.json.AcceptOrder;
import org.qualitech.foodnet.domain.json.CourierOrder;
import org.qualitech.foodnet.domain.json.OrderStatus;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.*;
import org.qualitech.foodnet.service.OrderService;
import org.qualitech.foodnet.util.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

/**
 * @author Aram Kirakosyan..
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    // Logger.
    private  static Logger logger = LogManager.getLogger(OrderServiceImpl.class);


    private final static int deliveryPay = 400;

    @Autowired
    private PartnerRepository partnerRepository;

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
        try {
            SmsSender.send("37455263065", order.toString());
            SmsSender.send("37495011842", order.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void acceptOrderByChef(AcceptOrder acceptOrder) throws AppException {
        // Check permission.
        if(partnerRepository.getByPartnerIdAndAccessToken(acceptOrder.getPartnerId(), acceptOrder.getAccessToken()).isEmpty()) {
            throw new AppException(ErrorCodes.PERMISSION_DENIED);
        }
        int minuteInMillis = 60000;
        //TODO Check if the chef is order owner
        Calendar date = Calendar.getInstance(TimeZone.getTimeZone("GMT+4:00"));
        long t = date.getTimeInMillis();
        Date preparationTime = new Date(t + (acceptOrder.getDuration() * minuteInMillis));

        orderRepository.updateOrderStatusANDPreparationTime(acceptOrder.getOrdersId(), OrderStatus.ACCEPTED_BY_CHEF, preparationTime, new Date());
    }

    @Override
    public void acceptOrderByCourier(AcceptOrder acceptOrder) throws AppException {
        // Check permission.
        if(partnerRepository.getByPartnerIdAndAccessToken(acceptOrder.getPartnerId(), acceptOrder.getAccessToken()).isEmpty()) {
            throw new AppException(ErrorCodes.PERMISSION_DENIED);
        }

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
    public String getCourierOrders(Long courierId) throws AppException, JsonProcessingException {
        List<Order> orders = orderRepository.findAllByOrderStatus(OrderStatus.ACCEPTED_BY_CHEF);
        CourierOrder courierOrder = new CourierOrder();
        List<CourierOrder> courierOrders = new ArrayList<CourierOrder>();
        if(orders.isEmpty()) {
            return "[]";
        }
        Order order = orders.get(0);
        Long chefId = orders.get(0).getChefId();
        List<Partner> chefs = partnerRepository.findByPartnerId(chefId);
        if(chefs.isEmpty()) {
            throw new AppException(ErrorCodes.WRONG_CHEF_IN_ORDER);
        }
        Partner chef = chefs.get(0);
        String from = chef.getLocation();
        String phone = chef.getPhone();
        String to = order.getLocation();

        courierOrder.setOrdersId(order.getOrdersId());
        courierOrder.setTo(to);
        courierOrder.setFrom(from);
        courierOrder.setChefPhone(phone);
        courierOrder.setClientPhone(order.getPhone());
        courierOrder.setChefPrice(order.getChefPrice());
        courierOrder.setTotalPrice(order.getPrice());
        courierOrder.setTime(order.getCompletedByChefTime().toString());
        courierOrder.setDeliveryPay(deliveryPay);

        courierOrders.add(courierOrder);

        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(courierOrders);
        updateOrderStatus(order.getOrdersId(), OrderStatus.SENT_TO_COURIER);
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
        int chefPrice = 0;
        long previousChefId = 0;
        for (DishOrder dor : order.getDishOrders()) {
            int count = dor.getCount();
            Dish dish = dishRepository.findOne((dor.getDish().getDishId()));

            chefPrice = (count * dish.getChefPrice()) + chefPrice;
            sum = (count * dish.getPrice()) + sum;
            currChefId = dishRepository.findChefByDishId(dish.getDishId()).get(0).getChef().getPartnerId();
            if (previousChefId != 0 && currChefId != previousChefId) {
                throw new AppException(ErrorCodes.MULTIPLE_CHEFS_IN_ORDER);
            }
            previousChefId = currChefId;
        }

        if (sum != order.getPrice()) {
            throw new AppException(ErrorCodes.WRONG_ORDER_PRICE);
        }
        order.setChefId(currChefId);
        order.setChefPrice(chefPrice);
        return currChefId;
    }

}
