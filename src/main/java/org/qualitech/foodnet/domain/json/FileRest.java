package org.qualitech.foodnet.domain.json;

import org.qualitech.foodnet.domain.File;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aram Kirakosyan.
 *
 * Model for file representation.
 */
public class FileRest {

    private long fileId;

    public FileRest(File file) {
        this.createDate = file.getCreateDate();
        this.dishId = file.getDishId();
        this.fileId = file.getFileId();
        this.name = file.getName();
        this.path = file.getPath();
    }

    public long getFileId() {
        return fileId;

    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    private String name;
    private String path;
    private String dishId;
    private Date createDate;

}
