package org.qualitech.foodnet.controller;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
     * @throws IOException  IOException
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
        if (service.phoneExists(phone)) {
            throw new AppException(ErrorCodes.PHONE_EXISTS);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.ACTIVATE_CHEF, method = RequestMethod.GET)
    public ResponseEntity activateChef(@RequestParam(value = "phone") String phone) throws AppException, NoSuchAlgorithmException {
        if (!service.phoneExists(phone)) {
            throw new AppException(ErrorCodes.WRONG_PHONE);
        }
        service.activateChef(phone);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.GET_CHEFS, method = RequestMethod.GET)
    public ResponseEntity getChefs(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) throws AppException {
        return new ResponseEntity(service.getChefs(page, count), HttpStatus.OK);
    }
}
