package org.qualitech.narinj.integration;

import org.junit.Assert;
import org.junit.Test;
import org.qualitech.foodnet.domain.Dish;
import org.qualitech.narinj.BaseTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for dish endpoints.
 *
 * @author Aram Kirakosyan.
 */
public class DishTest extends BaseTest {

    /**
     * Test for getting dishes.
     * 2 dishes will be added using sql script (add-dishes) before starting test.
     *
     * @throws Exception
     */
//    @Ignore
    @SuppressWarnings("unchecked")
    @Test
    @SqlGroup({
            @Sql("/sql/add-dishes.sql"),
            @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void getAllDishesTest() throws Exception {
        // Send request.
        MvcResult result = mockMvc.perform(get("/get-dishes?count=10&category=all&page=0")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk()).andReturn();
        // Get response body in json String
        String content = result.getResponse().getContentAsString();
        // Convert to dishes list.
        List <Dish> dishes = (List<Dish>) convertJsonToList(content, Dish.class);

        // Assertions.
        Assert.assertNotEquals(0, dishes.size());
        assertEquals(2, dishes.size());
        Dish dish1 = dishes.get(0);
        assertEquals("lunch", dish1.getCategories().get(0).getName());
        assertEquals("lunch1", dish1.getName().getEn());
        assertEquals("ланч1", dish1.getName().getRu());
        assertEquals("լանչ1", dish1.getName().getHy());
        assertEquals(120l, (long)dish1.getPrice());

        Dish dish2 = dishes.get(1);
        assertEquals("salad", dish2.getCategories().get(0).getName());
        assertEquals("salad1", dish2.getName().getEn());
        assertEquals("салат1", dish2.getName().getRu());
        assertEquals("աղցան1", dish2.getName().getHy());
        assertEquals(120l, (long)dish2.getPrice());
    }

    /**
     * Test case for getting dishes by category.
     *
     * @throws Exception
     */
    @Test
    @SqlGroup({
            @Sql("/sql/add-dishes.sql"),
            @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void getDishByCategoryTest() throws Exception {
        // Send request.
        MvcResult result = mockMvc.perform(get("/get-dishes?count=10&category=lunch&page=0")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk()).andReturn();
        // Get response body in json String
        String content = result.getResponse().getContentAsString();
        // Convert to dishes list.
        List <Dish> dishes = (List<Dish>) convertJsonToList(content, Dish.class);

        // Assertions.
        Assert.assertNotEquals(0, dishes.size());
        assertEquals(1, dishes.size());
        Dish dish1 = dishes.get(0);
        assertEquals("lunch1", dish1.getName().getEn());
        assertEquals("ланч1", dish1.getName().getRu());
        assertEquals("լանչ1", dish1.getName().getHy());
        assertEquals(120l, (long)dish1.getPrice());
    }

    /**
     * Test with one missing parameter in request.
     *
     * @throws Exception
     */
    @Test
    public void getDishesWrongParameters() throws Exception {
        // Send request and expect internal error.
        mockMvc.perform(get("/get-dishes?count=10&category=all")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().is5xxServerError()).andReturn();
    }

    /**
     * Test case for getting dishes by chef.
     *
     * @throws Exception
     */
    @Test
    @SqlGroup({
            @Sql("/sql/add-dishes.sql"),
            @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void getDishesByChefTest() throws Exception {
        // Send request and expect internal error.
        MvcResult result = mockMvc.perform(get("/get-dishes-by-chef?count=10&page=0&chefId=1")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk()).andReturn();
        // Get response body in json String
        String content = result.getResponse().getContentAsString();
        // Convert to dishes list.
        List <Dish> dishes = (List<Dish>) convertJsonToList(content, Dish.class);

        // Assertions.
        Assert.assertNotEquals(0, dishes.size());
        assertEquals(1, dishes.size());
        Dish dish1 = dishes.get(0);
        assertEquals("lunch", dish1.getCategories().get(0).getName());
        assertEquals("lunch1", dish1.getName().getEn());
        assertEquals("ланч1", dish1.getName().getRu());
        assertEquals("լանչ1", dish1.getName().getHy());
        assertEquals(120l, (long)dish1.getPrice());
    }

    @Test
    @SqlGroup({
            @Sql("/sql/add-dishes.sql"),
            @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void getDishesByWrongChefId() throws Exception {
        // Send request and expect internal error.
        MvcResult result = mockMvc.perform(get("/get-dishes-by-chef?count=10&page=0&chefId=8")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().is4xxClientError()).andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals("{\"errorString\":\"Wrong chef!\"}", content);
    }

    @Test
    public void getDishById() {

    }
}
