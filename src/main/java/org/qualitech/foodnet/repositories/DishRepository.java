package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Category;
import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface DishRepository extends CrudRepository<Dish, Long>, Repository<Dish, Long> {

    Long findCategoryIdByName(String name);

    List<Dish> findByChef(Chef chef, org.springframework.data.domain.Pageable pageable);

    List<Dish> findChefByDishId(long dishId);

    @Query("SELECT d FROM Dish d")
    List<Dish> findWithLimit(org.springframework.data.domain.Pageable pageable);

    @Query("SELECT d FROM Dish d join d.categories c WHERE c.categoryId = :categoryId")
    List<Dish> findByCategory(@Param ("categoryId") long categoryId, org.springframework.data.domain.Pageable pageable);
}
