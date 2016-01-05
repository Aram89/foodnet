package org.qualitech.foodnet.controller;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class ChefController {

    @Autowired
    ChefService service;

    @RequestMapping(value = RequestMappings.CREATE_CHEF, method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Chef chef) throws IOException, SQLException {
        service.createChef(chef);
        return new ResponseEntity(HttpStatus.OK);
    }
}
