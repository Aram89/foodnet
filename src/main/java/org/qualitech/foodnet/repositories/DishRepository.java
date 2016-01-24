package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

/**
 * @author Aram Kirakosyan.
 */
public interface DishRepository extends PagingAndSortingRepository<Dish, Long> {

    Long findCategoryIdByName(String name);

    //@Query("select dish from dish d where ")
    Page<Dish> findByCategories(Long categoryId, org.springframework.data.domain.Pageable pageable);

}
