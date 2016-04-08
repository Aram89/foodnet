package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.DishOrder;
import org.qualitech.foodnet.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 */
public interface DishOrderRepository extends CrudRepository<DishOrder, Long> {

    List<DishOrder> findByOrder(Order order);
}
