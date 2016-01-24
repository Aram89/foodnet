package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.File;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Aram Kirakosyan.
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {

    private final Integer FILES_COUNT_PER_FOLDER = 2000;

    // Change it for production.
    private final String ROOT_FOLDER = "C:/Users/Aram/Desktop/projects/foodnet/src/main/webapp/resources/site/assets/img/";

    private final String DELIMITER = "/";

    @Autowired
    private FileRepository repository;

    /**
     * Get type from mimeType.
     * @param mimeType mimeType.
     * @return file type.
     */
    private String getType (String mimeType) {
        String[] parts = mimeType.split("/");
        if(parts.length != 0) {
            return parts[0];
        }
        // Can't get type, returning mimeType.
        return mimeType;
    }


    public String createFilePath(String type) throws SQLException {
        Long fileId = repository.count() + 1;
        StringBuilder path = new StringBuilder();

        // Getting current year and month.
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        String today = formatter.format(new java.util.Date());

        // Getting folder based on file id.
        Long folder = (fileId / FILES_COUNT_PER_FOLDER) * FILES_COUNT_PER_FOLDER + FILES_COUNT_PER_FOLDER;

        path.append(ROOT_FOLDER).append(today).append(DELIMITER).append(type).append(DELIMITER).append(folder.toString());
        return path.toString();
    }

    public String createDirs(String type) throws SQLException {
        String path = createFilePath(type);
        java.io.File dir = new java.io.File(path);
        if (!dir.mkdirs()) {
            dir.mkdirs();
        }
        return path;
    }


    @Override
    public String uploadFile(MultipartFile multipartFile, Long userId) throws SQLException, IOException, AppException {
        String mimeType = multipartFile.getContentType();
        String type = getType(mimeType);
        String path = createDirs(type);
        if (!multipartFile.isEmpty()) {
            byte[] bytes = multipartFile.getBytes();
            //String fullPath = path + DELIMITER + (new Date().getTime()) + userId + multipartFile.getOriginalFilename();
            String fullPath = ROOT_FOLDER + DELIMITER + multipartFile.getOriginalFilename();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new java.io.File(fullPath)));
            stream.write(bytes);
            stream.close();
            return fullPath;
        } else {
            throw new AppException(ErrorCodes.EMPTY_FILE);
        }
    }

    @Override
    public Long insertFileInDB(File file) throws SQLException, AppException {
        return repository.save(file).getFileId();
    }
}
