package org.qualitech.foodnet.service;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.qualitech.foodnet.domain.Category;
import org.qualitech.foodnet.domain.Dish;
import org.qualitech.foodnet.domain.json.DishRest;
import org.qualitech.foodnet.repositories.Categoryrepository;
import org.qualitech.foodnet.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Service
@Transactional
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    Categoryrepository categoryrepository;

    @Override
    public void addDish(Dish dish) throws SQLException{
        dishRepository.save(dish);
    }


    @Override
    public String getDishes(String categoryName, int startIndex, int count) throws IOException {
        Category category = categoryrepository.findCategoryIdByName(categoryName).get(0);
        List<Dish> dishs = category.getDishes();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(dishs);
        return jsonInString;
         //dishRepository.findByCategories(id, new PageRequest(startIndex, count));
    }
}
