package org.qualitech.foodnet.controller;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class ChefController {

    @Autowired
    ChefService service;

    /**
     * Endpoint for becoming chef
     *
     * @param chef chef
     * @return status OK
     * @throws IOException IOException
     * @throws SQLException SQLException
     */
    @RequestMapping(value = RequestMappings.CREATE_CHEF, method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Chef chef) throws IOException, SQLException {
        service.createChef(chef);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint for checking chef email
     * Throws AppException with code phoneExists if phone exists,
     * otherwise returns status OK
     *
     * @param phone chef phone
     * @return status OK
     * @throws AppException AppException
     */
    @RequestMapping(value = RequestMappings.CHECK_PHONE, method = RequestMethod.GET)
    public ResponseEntity checkPhone(@RequestParam(value = "phone") String phone) throws AppException {
        if(service.phoneExists(phone)) {
            throw new AppException(ErrorCodes.PHONE_EXISTS);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
