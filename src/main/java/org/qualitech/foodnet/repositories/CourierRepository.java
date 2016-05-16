package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.Courier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author Aram Kirakosyan.
 */
public interface CourierRepository extends CrudRepository<Courier, Long>, Repository<Courier, Long> {
}
