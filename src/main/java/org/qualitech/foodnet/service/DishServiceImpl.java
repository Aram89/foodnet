package org.qualitech.foodnet.service;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.qualitech.foodnet.domain.Category;
import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.Dish;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.Categoryrepository;
import org.qualitech.foodnet.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Dish> getDishes(String categoryName, int page, int count) throws IOException, AppException {
        List <Dish> dishes;
        if (categoryName.equalsIgnoreCase("all")) {
            dishes = (List<Dish>) dishRepository.findWithLimit(new PageRequest(page, count));
        } else {
            if (categoryrepository.findCategoryIdByName(categoryName).isEmpty()) {
                throw new AppException(ErrorCodes.WRONG_CATEGORY + categoryName);
            }
            Category category = categoryrepository.findCategoryIdByName(categoryName).get(0);
            dishes = dishRepository.findByCategory(category.getCategoryId(), new PageRequest(page, count));
        }
        return dishes;
    }

    @Override
    public List<Dish> getDishesByChef(int chefId, int page, int count) throws IOException {
        Chef chef = new Chef(chefId);
        List<Dish> dishes = dishRepository.findByChef(chef, new PageRequest(page, count));
        return dishes;
    }
}
