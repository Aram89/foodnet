package org.qualitech.foodnet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.Courier;
import org.qualitech.foodnet.domain.Partner;
import org.qualitech.foodnet.domain.json.WorkStatus;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.service.CourierService;
import org.qualitech.foodnet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class CourierController {

    // Logger.
    private  static Logger logger = LogManager.getLogger(CourierController.class);

    // Service.
    @Autowired
    CourierService service;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = RequestMappings.COURIER_LOGIN, method = RequestMethod.POST)
    public ResponseEntity addDish(@RequestBody String decodedString) throws SQLException, IOException, AppException, NoSuchAlgorithmException {
        String chefString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        Courier courier = mapper.readValue(chefString, Courier.class);
        Partner loggedChef = service.login(courier.getPhone(), courier.getPassword());

        return new ResponseEntity(loggedChef, HttpStatus.OK);
    }


    /**
     * Endpoint for becoming courier
     *
     * @param courier courier
     * @return status OK
     * @throws IOException  IOException
     * @throws java.sql.SQLException SQLException
     */
    @RequestMapping(value = RequestMappings.CREATE_COURIER, method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Courier courier) throws IOException, SQLException {
        logger.info("new courier :" + courier);
        service.create(courier);
        logger.info("Courier registered with id: " + courier.getPartnerId());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint for checking chef phone
     * Throws AppException with code phoneExists if phone exists,
     * otherwise returns status OK
     *
     * @param phone chef phone
     * @return status OK
     * @throws AppException AppException.
     */
    @RequestMapping(value = RequestMappings.CHECK_COURIER_PHONE, method = RequestMethod.GET)
    public ResponseEntity checkPhone(@RequestParam(value = "phone") String phone) throws AppException {
        if (service.phoneExists(phone)) {
            throw new AppException(ErrorCodes.PHONE_EXISTS);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = RequestMappings.PARTNER_COURIER, method = RequestMethod.GET)
    public String partnerCourierPage() {
        return RequestMappings.PARTNER_COURIER;
    }

    @RequestMapping(value = RequestMappings.COURIER_CONNECT, method = RequestMethod.POST)
    public ResponseEntity connect(@RequestBody String decodedString) throws IOException, AppException {
        Courier courier = convert(decodedString);
        if(!service.checkAccessToken(courier.getPartnerId(), courier.getAccessToken())) {
            throw new AppException(ErrorCodes.WRONG_ACCESS_TOKEN);
        }
        // Update work status.
        service.updateWorkStatus(courier.getPartnerId(), WorkStatus.ONLINE);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.COURIER_DISCONNECT, method = RequestMethod.POST)
    public ResponseEntity disConnect(@RequestBody String decodedString) throws IOException, AppException {
        Courier courier = convert(decodedString);
        if(!service.checkAccessToken(courier.getPartnerId(), courier.getAccessToken())) {
            throw new AppException(ErrorCodes.WRONG_ACCESS_TOKEN);
        }
        // Update work status.
        service.updateWorkStatus(courier.getPartnerId(), WorkStatus.OFFLINE);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = RequestMappings.GET_COURIER_ORDERS, method = RequestMethod.POST)
    public ResponseEntity getOrders(@RequestBody String decodedString) throws IOException, AppException {
        logger.info("Courier get orders request :" + decodedString);
        Courier courier = convert(decodedString);
        // Check credentials
        if(!service.checkAccessToken(courier.getPartnerId(), courier.getAccessToken())) {
            throw new AppException(ErrorCodes.WRONG_ACCESS_TOKEN);
        }
        // Update work status update time.
        String orders = orderService.getCourierOrders(courier.getPartnerId());
        service.updateWorkStatusUpdateTime(courier.getPartnerId(), new Date());
        return new ResponseEntity(orders, HttpStatus.OK);
    }

    private Courier convert(String decodedString) throws IOException {
        String courierString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        Courier courier = mapper.readValue(courierString, Courier.class);
        return courier;
    }
}
