package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.Dish;
import org.springframework.data.domain.Page;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface DishService {

    public void addDish(Dish dish) throws SQLException;
    public List <Dish> getDishes (String categoryName, int startIndex, int count);

}
