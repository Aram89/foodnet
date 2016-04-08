package org.qualitech.foodnet.service;

import org.codehaus.jackson.JsonGenerationException;
import org.qualitech.foodnet.domain.Dish;
import org.qualitech.foodnet.exception.AppException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface DishService {

    public void addDish(Dish dish) throws SQLException;
    public List<Dish> getDishes (String categoryName, int page, int count) throws IOException, AppException;

    public List<Dish> getDishesByChef (Long chefId, int page, int count) throws IOException;
}
