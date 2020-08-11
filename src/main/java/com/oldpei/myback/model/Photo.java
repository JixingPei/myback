package com.oldpei.myback.model;

import java.util.Date;

public class Photo extends BaseModel {
    private Integer uniqueId;

    private String date;

    private String type;

    private String name;

    private String path;

    public Photo() {
        super();
    }

    public Photo(Integer uniqueId, String date, String type, String name, String path, String activeFlg, String sysInsertId, Date sysInsertDate, String sysUpdateId, Date sysUpdateDate) {
        super(activeFlg, sysInsertId, sysInsertDate, sysUpdateId, sysUpdateDate);
        this.uniqueId = uniqueId;
        this.date = date;
        this.type = type;
        this.name = name;
        this.path = path;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

}