package org.qualitech.foodnet.service;

import org.codehaus.jackson.JsonGenerationException;
import org.qualitech.foodnet.domain.Dish;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface DishService {

    public void addDish(Dish dish) throws SQLException;
    public String getDishes (String categoryName, int startIndex, int count) throws IOException;

}
