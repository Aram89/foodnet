package org.qualitech.foodnet.authorization;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * Filter for checking and verifying jwt for protected paths.
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

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // Get jwt token from authorization header.
        String token = httpServletRequest.getHeader("Authorization");

        if (token == null) {
            // No jwt token, send error response to client.
            generateAndSendErrorResponse((HttpServletResponse) response, "No JWT token");
            return;
        }

        // Create jwt verifier with secret value.
        JWTVerifier jwtVerifier = new JWTVerifier(secret);
        try {
            // Verify jwt.
            jwtVerifier.verify(token);
        } catch (NoSuchAlgorithmException | JWTVerifyException | InvalidKeyException | SignatureException e) {
            // jwt is not valid, send error response to client.
            generateAndSendErrorResponse((HttpServletResponse) response, e.getMessage());
            //((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
        // JWT validation passed, continue filter.
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void generateAndSendErrorResponse (HttpServletResponse httpServletResponse, String message) throws IOException {
        ErrorCodes errorCodes = new ErrorCodes(message);
        // jwt is not valid, send error response to client.
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(convertObjectToJson(errorCodes));
        httpServletResponse.flushBuffer();
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
