package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.domain.OrderStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Aram Kirakosyan.
 */
public interface OrderRepository extends CrudRepository<Order, Long>{

    @Modifying
    @Query("update Order o set o.status = :status where o.ordersId = :orderId")
    void updateOrderStatus(@Param("orderId") long orderId, @Param("status")OrderStatus status);
}
