package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface Categoryrepository extends CrudRepository<Category, Long> {

    public List<Category> findCategoryIdByName(String name);
}
