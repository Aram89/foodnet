package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Chef;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author Aram Kirakosyan.
 */
public interface ChefRepository extends CrudRepository<Chef, Integer> {

}
