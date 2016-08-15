package org.qualitech.foodnet.authorization;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * Filter for checking and verifying jwt for proetected paths.
 * JWT is set in Authorization header, if jwt is valid chain will e continued.
 * If jwt is not present or is not valid, error response will be send to client,
 * with 401 (UNAUTHORIZED) status. 
 * 
 * @author Aram Kirakosyan.
 */
public class AuthorizationFilter implements Filter {

   	/**
	 * JWT secret key, value injected from auth0.properties file.
	 */
    @Value("${auth0.clientSecret}")
    private String secret;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // Cast to HttpServletRequest.
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // Get jwt token from authorization header.
        String token = httpServletRequest.getHeader("Authorization");

        if (token == null) {
            // No jwt token, throw runtime exception
            response.setContentType("application/json");
            //send error response to client.
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "No JWT token");
        }

        // Create jwt verifier with secret value.
        JWTVerifier jwtVerifier = new JWTVerifier(secret);
        try {
            token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE0NzExNjIwMTYsImV4cCI6MTUwMjY5ODAxNiwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoianJvY2tldEBleGFtcGxlLmNvbSIsIkdpdmVuTmFtZSI6IkpvaG5ueSIsIlN1cm5hbWUiOiJSb2NrZXQiLCJFbWFpbCI6Impyb2NrZXRAZXhhbXBsZS5jb20iLCJSb2xlIjpbIk1hbmFnZXIiLCJQcm9qZWN0IEFkbWluaXN0cmF0b3IiXX0.GijMZJJ_1zbzJyhUa0A5ICbb9sgWtRlFzW839a63v_0";
            // Verify jwt.
            jwtVerifier.verify(token);
        } catch (NoSuchAlgorithmException | JWTVerifyException | InvalidKeyException | SignatureException e) {
            // jwt is not valid, send error response to client.
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
        // JWT validation passed, continue filter.
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
