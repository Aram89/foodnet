package org.qualitech.foodnet.controller;

import org.qualitech.foodnet.domain.Category;
import org.qualitech.foodnet.domain.Dish;
import org.qualitech.foodnet.repositories.Categoryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class CategoryController {

    @Autowired
    Categoryrepository repository;

    @RequestMapping(value = RequestMappings.ADD_CATEGORIES, method = RequestMethod.POST)
    public void addDish(@RequestBody Category category) {
        repository.save(category);
    }
}
