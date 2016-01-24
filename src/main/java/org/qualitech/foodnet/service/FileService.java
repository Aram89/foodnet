package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.File;
import org.qualitech.foodnet.exception.AppException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Aram Kirakosyan.
 */
public interface FileService {

    String uploadFile(MultipartFile file, Long userId) throws SQLException, IOException, AppException;
    public Long insertFileInDB(File file) throws SQLException, AppException;

}
