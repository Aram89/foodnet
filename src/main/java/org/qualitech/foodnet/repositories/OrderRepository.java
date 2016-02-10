package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Aram Kirakosyan.
 */
public interface OrderRepository extends CrudRepository<Order, Long>{
}
