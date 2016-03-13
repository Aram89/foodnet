package org.qualitech.foodnet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.sdk.TwilioRestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.service.ChefService;
import org.qualitech.foodnet.util.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class ChefController {

    // Logger.
    private  static Logger logger = LogManager.getLogger(ChefController.class);

    // Service.
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
        logger.info("new chef :" + chef);
        service.createChef(chef);
        logger.info("Chef registered with id: " + chef.getChefId());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint for checking chef phone
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

    /**
     * Endpoint for activating chef.
     *
     * @param phone phone.
     * @return
     * @throws AppException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = RequestMappings.ACTIVATE_CHEF, method = RequestMethod.GET)
    public ResponseEntity activateChef(@RequestParam(value = "phone") String phone) throws AppException, NoSuchAlgorithmException, TwilioRestException {
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

    @RequestMapping(value = RequestMappings.LOGIN, method = RequestMethod.POST)
    public ResponseEntity addDish(@RequestBody String decodedString) throws SQLException, IOException, AppException, NoSuchAlgorithmException {
        String chefString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        Chef chef = mapper.readValue(chefString, Chef.class);
        service.login(chef.getPhone(), chef.getPassword());
        Chef loggedChef = new Chef();
        loggedChef.setChefId(chef.getChefId());
        loggedChef.setAccessToken(chef.getAccessToken());
        return new ResponseEntity(loggedChef, HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.PARTNER_CHEF, method = RequestMethod.GET)
    public String partnerChefPage() {
        return "partner-chef";
    }

    @RequestMapping(value = RequestMappings.PARTNER_COURIER, method = RequestMethod.GET)
    public String partnerCourierPage() {
        return "partner-courier";
    }
}
