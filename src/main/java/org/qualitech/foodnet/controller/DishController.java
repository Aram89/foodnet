package org.qualitech.foodnet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qualitech.foodnet.domain.Dish;
import org.qualitech.foodnet.domain.File;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.service.DishService;
import org.qualitech.foodnet.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.net.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class DishController {

    // Logger.
    private  static Logger logger = LogManager.getLogger(DishController.class);

    @Autowired
    private FileService fileService;

    @Autowired
    private DishService dishService;

    /**
     * Endpoint for uploading file.
     *
     * @param multipartFile file.
     * @return Saved file id and HTTP status OK.
     * @throws IOException
     * @throws AppException
     * @throws SQLException
     */
    @RequestMapping(value = RequestMappings.UPLOAD_FILE, method = RequestMethod.POST)
    public ResponseEntity UploadFile(@RequestParam("file") MultipartFile multipartFile)
            throws IOException, AppException, SQLException {
        logger.info("New file : " + multipartFile.getOriginalFilename());
        String path  = fileService.uploadFile(multipartFile, 1l);

        // create domain object and set fields for file.
        File file = new File();
        file.setPath(multipartFile.getOriginalFilename());
        file.setName(multipartFile.getOriginalFilename());
        file.setCreateDate(new Date());
        file.setMimeType(multipartFile.getContentType());

        // Insert into DB and get inserted entry id.
        long fileId = fileService.insertFileInDB(file);

        logger.info("File successfully uploaded " + file.getPath());
        // Return uploaded file id and status OK.
        return new ResponseEntity(fileId, HttpStatus.OK);
    }

    /**
     * Endpoint for adding dish from mobile app.
     * json contains name, description, price, chef (id),
     * categories (categories ids), files
     * (file ids associated with dish for now only one).
     *
     * @param decodedString dish in json string.
     */
    @RequestMapping(value = RequestMappings.ADD_DISH, method = RequestMethod.POST)
    public ResponseEntity addDish(@RequestBody String decodedString) throws SQLException, IOException {
        logger.info("New dish add request :" + decodedString);
        String dishString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        Dish dish = mapper.readValue(dishString, Dish.class);
        logger.info("New dish: " + dish);
        dishService.addDish(dish);
        logger.info("Dish successfully added :" + dish.getName());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint for getting dishes.
     *
     * @param category category name (all if request all dishes).
     * @param page page starting with 0.
     * @param count dishes count per request.
     * @return List of dishes.
     * @throws SQLException
     * @throws IOException
     * @throws AppException
     */
    @RequestMapping(value = RequestMappings.GET_DISHES, method = RequestMethod.GET)
    public ResponseEntity getDishes(@RequestParam(value = "category") String category,
                                    @RequestParam(value = "page") int page,
                                    @RequestParam(value = "count") int count) throws SQLException, IOException, AppException {
        List<Dish> dishes = dishService.getDishes(category, page, count);
        return new ResponseEntity(dishes, HttpStatus.OK);
    }

    /**
     * Endpoint for getting chef's dishes.
     *
     * @param chefId chef id.
     * @param page page starting with 0.
     * @param count count.
     * @return list of dishes.
     * @throws SQLException
     * @throws IOException
     * @throws AppException
     */
    @RequestMapping(value = RequestMappings.GET_DISHES_BY_CHEF, method = RequestMethod.GET)
    public ResponseEntity getDishesByChef(@RequestParam(value = "chefId") Long chefId,
                                            @RequestParam(value = "page") int page,
                                            @RequestParam(value = "count") int count) throws SQLException, IOException, AppException {
        List<Dish> dishes = dishService.getDishesByChef(chefId, page, count);
        return new ResponseEntity(dishes, HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.GET_DISH, method = RequestMethod.GET)
    public ResponseEntity getDish(@RequestParam(value = "dishId") Long dishId) {
        Dish dish = dishService.getDish(dishId);
        return new ResponseEntity(dish, HttpStatus.OK);
    }
}
