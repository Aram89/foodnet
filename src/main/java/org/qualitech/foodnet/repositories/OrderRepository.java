package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Order;
import org.qualitech.foodnet.domain.json.OrderStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Modifying
    @Query("update Order o set o.orderStatus = :orderStatus, o.completedByChefTime = :completedByChefTime, o.acceptedByChefTime = :acceptedByChefTime where o.ordersId = :orderId")
    void updateOrderStatusANDPreparationTime(@Param("orderId") long orderId,
                                             @Param("orderStatus")OrderStatus orderStatus,
                                             @Param("completedByChefTime") Date completedByChefTime,
                                             @Param("acceptedByChefTime") Date acceptedByChefTime);

    @Modifying
    @Query("update Order o set o.orderStatus = :orderStatus where o.ordersId = :orderId")
    void updateOrderStatus(@Param("orderId") long orderId, @Param("orderStatus")OrderStatus orderStatus);

    List<Order> findByChefIdAndOrderStatus(Long chefId, OrderStatus orderStatus);

    @Query("SELECT o FROM Order o where o.orderStatus = :orderStatus Order by date")
    List<Order> findAllByOrderStatus(@Param("orderStatus") OrderStatus orderStatus);
}
