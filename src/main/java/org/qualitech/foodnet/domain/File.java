package org.qualitech.foodnet.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aram Kirakosyan.
 *
 * Model for file representation.
 */
@Entity
@Table(name = "file")
public class File {

    private long fileId;
    private String name;
    private String path;
    private String mimeType;
    private String dishId;
    private Date createDate;

    @Id
    @GeneratedValue
    @Column(name = "fileId")
    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    @Column
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "dishId")
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String postId) {
        this.dishId = postId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "mimeType")
    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
