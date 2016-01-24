package org.qualitech.foodnet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * @author Aram Kirakosyan.
 */
@Controller
public class DishController {

    @Autowired
    private FileService fileService;

    @Autowired
    private DishService dishService;

    @RequestMapping(value = RequestMappings.UPLOAD_FILE, method = RequestMethod.POST)
    public ResponseEntity UploadFile(@RequestParam("file") MultipartFile multipartFile)
            throws IOException, AppException, SQLException {
        // Getting user form session.
//        User user = UserServiceImpl.getUser();
        // Upload file and get file path.
        String path  = fileService.uploadFile(multipartFile, 1l);

        // create domain object and set fields for file.
        File file = new File();
        file.setPath(multipartFile.getOriginalFilename());
        file.setName(multipartFile.getOriginalFilename());
        file.setCreateDate(new Date());
        file.setMimeType(multipartFile.getContentType());

        // Insert into DB and get inserted entry id.
        long fileId = fileService.insertFileInDB(file);
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
        String dishString = URLDecoder.decode(decodedString, "UTF-8").substring(5);
        ObjectMapper mapper = new ObjectMapper();
        Dish dish = mapper.readValue(dishString, Dish.class);
        dishService.addDish(dish);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RequestMappings.GET_DISHES, method = RequestMethod.GET)
    public ResponseEntity getDishes(@RequestParam(value = "category") String category,
                                    @RequestParam(value = "start") int start,
                                    @RequestParam(value = "count") int count) throws SQLException, IOException {
        String dishes = dishService.getDishes(category, start, count);
        return new ResponseEntity(dishes, HttpStatus.OK);
    }
}
