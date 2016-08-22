package org.qualitech.narinj.integration;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.qualitech.narinj.BaseTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.Assert.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test cases for Authorization.
 *
 * @author Aram Kirakosyan.
 */
public class AuthorizationTest extends BaseTest {

    /**
     * Signed with secret from auth0.properties.
     */
    private static final String VALID_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL25hcmluai5hdXRoMC5jb20vIiwiaWF0IjoxNDcxODEwMzEwLCJleHAiOjE1MDMzNDYzMTAsImF1ZCI6Ind3dy5leGFtcGxlLmNvbSIsInN1YiI6Impyb2NrZXRAZXhhbXBsZS5jb20iLCJHaXZlbk5hbWUiOiJKb2hubnkiLCJTdXJuYW1lIjoiUm9ja2V0IiwiRW1haWwiOiJqcm9ja2V0QGV4YW1wbGUuY29tIiwiUm9sZSI6WyJNYW5hZ2VyIiwiUHJvamVjdCBBZG1pbmlzdHJhdG9yIl19.9lFondBb1PQVBQb87G0lv9-PlrRi155YynO-D_q6TRE";

    /**
     * Signed with wrong secret.
     */
    private static final String INVALID_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL25hcmluai5hdXRoMC5jb20vIiwiaWF0IjoxNDcxODEwMzEwLCJleHAiOjE1MDMzNDYzMTAsImF1ZCI6Ind3dy5leGFtcGxlLmNvbSIsInN1YiI6Impyb2NrZXRAZXhhbXBsZS5jb20iLCJHaXZlbk5hbWUiOiJKb2hubnkiLCJTdXJuYW1lIjoiUm9ja2V0IiwiRW1haWwiOiJqcm9ja2V0QGV4YW1wbGUuY29tIiwiUm9sZSI6WyJNYW5hZ2VyIiwiUHJvamVjdCBBZG1pbmlzdHJhdG9yIl19.SdlqzyvhwSmGMQO5Ey2FIcKxzL9K0J_yvRLT8OWNIE4";

    /**
     * Test case for authorization ok.
     * Will send request to protected path with valid jwt in Authorization header.
     */
    @Test
    public void authorizationOkTest () throws Exception {
        mockMvc.perform(get("/user/test")
                .header("AUTHORIZATION", VALID_JWT)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    /**
     * Test case for failed authorization.
     * JWT is not valid in Authorization header.
     *
     * @throws Exception
     */
    @Test
    public void authorizationWithInValidJWTTest() throws Exception {
        // Send request with invalid jwt.
        MvcResult result = mockMvc.perform(get("/user/test")
                .header("AUTHORIZATION", INVALID_JWT)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andReturn();
        // Assertions (status and error message).
        assertEquals(HttpStatus.SC_UNAUTHORIZED, result.getResponse().getStatus());
        String content = result.getResponse().getContentAsString();
        assertEquals("{\"errorString\":\"signature verification failed\"}", content);
    }

    /**
     * Test case for failed authorization.
     * JWT is not set in authorization header.
     *
     * @throws Exception
     */
    @Test
    public void authorizationWithoutJWTInHeader() throws Exception {
        // Send request with invalid jwt.
        MvcResult result = mockMvc.perform(get("/user/test")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andReturn();
        // Assertions (status and error message).
        assertEquals(HttpStatus.SC_UNAUTHORIZED, result.getResponse().getStatus());
        String content = result.getResponse().getContentAsString();
        assertEquals("{\"errorString\":\"No JWT token\"}", content);
    }
}
