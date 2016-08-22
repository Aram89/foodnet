package org.qualitech.foodnet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Aram Kirakosyan..
 */
@Controller
public class UserController {

    /**
     * Endpoint only for testing authorization filter in isolation from other functionality.
     * Simply return ok status.
     *
     * @return status OK.
     */
    @RequestMapping(value = RequestMappings.USER_TEST, method = RequestMethod.GET)
    public ResponseEntity test () {
        return new ResponseEntity(HttpStatus.OK);
    }
}
