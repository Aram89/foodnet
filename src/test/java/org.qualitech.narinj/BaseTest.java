package org.qualitech.narinj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.io.IOException;
import java.util.List;

/**
 * Base class for tests, initializing context and in memory hsql DB .
 *
 * @author Aram Kirakosyan.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class BaseTest {

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Autowired
    private Filter springSecurityFilterChain;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
        .addFilters(springSecurityFilterChain)
        .build();
        showDBManager();
    }

    private void showDBManager() {
        DatabaseManagerSwing.main(new String[] {
                "--url",  "jdbc:hsqldb:mem:testdb", "--noexit"
        });
    }

    protected List <?> convertJsonToList (String jsonString, Class <?> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final TypeFactory factory = mapper.getTypeFactory();
        final JavaType listOfT = factory.constructCollectionType(List.class, clazz);
        List <?> objects = mapper.readValue(jsonString, listOfT);
        return objects;
    }

    protected String convertObjectToJsonString (Object object) throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}