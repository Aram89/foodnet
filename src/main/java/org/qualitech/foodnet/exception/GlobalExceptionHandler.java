package org.qualitech.foodnet.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

/**
 * Class for handling exceptions
 * @author Aram Kirakosyan.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private  static Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);


    /**
     * Returning INTERNAL_SERVER_ERROR
     * for all unhandled exceptions
     *
     * @param e Exception.
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        logger.error(e);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Returning INTERNAL_SERVER_ERROR
     * for all unhandled exceptions
     *
     * @param se sql Exception.
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorCodes sqlException(Exception se) {
        logger.error(se);
        return new ErrorCodes("wrong id");
    }


    /**
     * Returning bad request status
     * and error string for user exceptions
     * @param ae Exception.
     * @return error string in json.
     */

    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorCodes userException (AppException ae) {
        logger.error("App Exception : " + ae);
        return new ErrorCodes(ae.getMessage());
    }
}