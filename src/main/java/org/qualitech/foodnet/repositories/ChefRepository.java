package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Chef;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface ChefRepository extends CrudRepository <Chef, Integer> {

    List<Chef> findByPhone(String phone);
}
