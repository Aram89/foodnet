package org.qualitech.foodnet.controller;

import com.auth0.jwt.JWTVerifyException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.sdk.TwilioRestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.Partner;
import org.qualitech.foodnet.domain.json.WorkStatus;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.service.ChefService;
import org.qualitech.foodnet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class ChefController {

    // Logger.
    private static Logger logger = LogManager.getLogger(ChefController.class);

    // Service.
    @Autowired
    private ChefService service;

    @Autowired
    private OrderService orderService;

    /**
     * Endpoint for becoming chef.
     *
     * @param chef chef
     * @return status OK
     * @throws IOException  IOException
     * @throws SQLException SQLException
     */
    @RequestMapping(value = RequestMappings.CREATE_CHEF, method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ResponseEntity create(@RequestBody Chef chef) throws IOException, SQLException {
        logger.info("New chef register request : " + chef.getName());

        service.create(chef);
        // Chef registered successfully.
        logger.info("Chef registered with id: " + chef.getPartnerId());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint for checking chef phone.
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
     * Endpoint for activating partner.
     *
     * @param phone phone.
     * @return status ok.
     * @throws AppException if there is no chef with given phone.
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = RequestMappings.ACTIVATE_PARTNER, method = RequestMethod.GET)
    public ResponseEntity activateChef(@RequestParam(value = "phone") String phone) throws AppException, NoSuchAlgorithmException, TwilioRestException {
        if (!service.phoneExists(phone)) {
            throw new AppException(ErrorCodes.WRONG_PHONE);
        }
        service.activate(phone);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.GET_CHEFS, method = RequestMethod.GET)
    public ResponseEntity getChefs(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) throws AppException, SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {
        return new ResponseEntity(service.getChefs(page, count), HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.CHEF_LOGIN, method = RequestMethod.POST)
    public ResponseEntity addDish(@RequestBody String decodedString) throws SQLException, IOException, AppException, NoSuchAlgorithmException {
        String chefString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        Chef chef = mapper.readValue(chefString, Chef.class);
        Partner loggedChef = service.login(chef.getPhone(), chef.getPassword());

        return new ResponseEntity(loggedChef, HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.PARTNER_CHEF, method = RequestMethod.GET)
    public String partnerChefPage() {
        return "partner-chef";
    }

    @RequestMapping(value = RequestMappings.CHEF_CONNECT, method = RequestMethod.POST)
    public ResponseEntity connect(@RequestBody String decodedString) throws IOException, AppException {
        Chef chef = convert(decodedString);
        if (!service.checkAccessToken(chef.getPartnerId(), chef.getAccessToken())) {
            throw new AppException(ErrorCodes.WRONG_ACCESS_TOKEN);
        }
        // Update work status.
        service.updateWorkStatus(chef.getPartnerId(), WorkStatus.ONLINE);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.CHEF_DISCONNECT, method = RequestMethod.POST)
    public ResponseEntity disConnect(@RequestBody String decodedString) throws IOException, AppException {
        Chef chef = convert(decodedString);
        if (!service.checkAccessToken(chef.getPartnerId(), chef.getAccessToken())) {
            throw new AppException(ErrorCodes.WRONG_ACCESS_TOKEN);
        }
        // Update work status.
        service.updateWorkStatus(chef.getPartnerId(), WorkStatus.OFFLINE);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = RequestMappings.GET_ORDERS, method = RequestMethod.POST)
    public ResponseEntity getOrders(@RequestBody String decodedString) throws IOException, AppException {
        Chef chef = convert(decodedString);
        // Check credentials
        if (!service.checkAccessToken(chef.getPartnerId(), chef.getAccessToken())) {
            throw new AppException(ErrorCodes.WRONG_ACCESS_TOKEN);
        }
        // Update work status update time.
        String orders = orderService.getOrders(chef.getPartnerId());
        ObjectMapper mapper = new ObjectMapper();

        service.updateWorkStatusUpdateTime(chef.getPartnerId(), new Date());

        return new ResponseEntity(orders, HttpStatus.OK);
    }

    private Chef convert(String decodedString) throws IOException {
        String chefString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        Chef chef = mapper.readValue(chefString, Chef.class);
        return chef;
    }
//
//    @RequestMapping(value = RequestMappings.SEND_EMAIL, method = RequestMethod.POST)
//    public ResponseEntity sendEmail(@RequestBody Message message) throws IOException, AppException {
//        mailService.send(message);
//        return new ResponseEntity(HttpStatus.OK);
//    }
}