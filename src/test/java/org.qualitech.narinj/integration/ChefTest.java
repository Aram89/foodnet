package org.qualitech.narinj.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.qualitech.foodnet.controller.RequestMappings;
import org.qualitech.foodnet.domain.Partner;
import org.qualitech.narinj.BaseTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.Assert.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for chef endpoints.
 *
 * @author Aram Kirakosyan.
 */
public class ChefTest extends BaseTest {

    /**
     * Test case for creating chef (Ok case).
     *
     * @throws Exception
     */
    @Test
    @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void createChefTest() throws Exception {
        // Prepare data.
        Partner chef = new Partner();
        chef.setName("Gago");
        chef.setPhone("+3745555555");
        String jsonContent = convertObjectToJsonString(chef);

        mockMvc.perform(post("/create-chef")
                .content(jsonContent)
                .contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk()).andReturn();
        // TODO add assertion for checking persisted data.
    }

    /**
     * Test case for check phone, which not exists (OK case).
     *
     * @throws Exception
     */
    @Test
    @SqlGroup({
            @Sql("/sql/add-chef.sql"),
            @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void checkPhoneTest() throws Exception {
        mockMvc.perform(get("/check-phone?phone=37455000000"))
                .andExpect(status().isOk());
    }

    /**
     * Test case for check phone, which not exists (OK case).
     *
     * @throws Exception
     */
    @Test
    @SqlGroup({
            @Sql("/sql/add-chef.sql"),
            @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void checkPhoneExistTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/check-phone?phone=37455555555"))
                .andExpect(status().is4xxClientError()).andReturn();
        assertEquals("{\"errorString\":\"phoneExists\"}", result.getResponse().getContentAsString());
    }

    @Test
    @SqlGroup({
            @Sql("/sql/add-chef.sql"),
            @Sql(scripts = "/sql/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void activateChefTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/qwertyuiopasdfghjkl?phone=37455555555"))
                .andExpect(status().isOk()).andReturn();
        // TODO add assertion to check chef status set to ACTIVE and generated password.
    }

    @Test
    public void getChefsTest() {

    }
}
