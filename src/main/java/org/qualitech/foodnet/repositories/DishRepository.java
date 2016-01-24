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

//    @Query("SELECT d FROM Dish AS d INNER JOIN dishCategory AS dp ON d.dishId = dp.dishId  INNER JOIN Category" +
//            " AS c\n" +
//            "    ON c.categoryId = dp.categoryId\n" +
//            "WHERE dp.categoryId = :categoryId ")
//    Page<Dish> findByCategories(Long categoryId, org.springframework.data.domain.Pageable pageable);

}
