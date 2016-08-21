package org.qualitech.narinj.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Assert;
import org.junit.Test;
import org.qualitech.foodnet.domain.Dish;
import org.qualitech.narinj.BaseTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Aram Kirakosyan.
 */
public class DishTest extends BaseTest {

    /**
     * Test for getting dishes.
     * 2 dishes will be added using sql script (add-dishes) before starting test.
     *
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Test
    @Sql({"/sql/add-dishes.sql"})
    public void getDishesTest() throws Exception {
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
        assertEquals("dish1", dish1.getName().getEn());
        assertEquals("блюда1", dish1.getName().getRu());
        assertEquals("ուտելիք1", dish1.getName().getHy());
        assertEquals(120l, (long)dish1.getPrice());

        Dish dish2 = dishes.get(1);
        assertEquals("dish2", dish2.getName().getEn());
        assertEquals("блюда2", dish2.getName().getRu());
        assertEquals("ուտելիք2", dish2.getName().getHy());
        assertEquals(120l, (long)dish2.getPrice());
    }
}
