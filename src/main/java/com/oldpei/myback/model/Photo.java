package com.oldpei.myback.model;

import java.util.Date;

public class Photo {
    private Integer uniqueId;

    private String date;

    private String type;

    private String name;

    private String path;

    private String storage;

    private String activeFlg;

    private String sysInsertId;

    private Date sysInsertDate;

    private String sysUpdateId;

    private Date sysUpdateDate;

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

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage == null ? null : storage.trim();
    }

    public String getActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(String activeFlg) {
        this.activeFlg = activeFlg == null ? null : activeFlg.trim();
    }

    public String getSysInsertId() {
        return sysInsertId;
    }

    public void setSysInsertId(String sysInsertId) {
        this.sysInsertId = sysInsertId == null ? null : sysInsertId.trim();
    }

    public Date getSysInsertDate() {
        return sysInsertDate;
    }

    public void setSysInsertDate(Date sysInsertDate) {
        this.sysInsertDate = sysInsertDate;
    }

    public String getSysUpdateId() {
        return sysUpdateId;
    }

    public void setSysUpdateId(String sysUpdateId) {
        this.sysUpdateId = sysUpdateId == null ? null : sysUpdateId.trim();
    }

    public Date getSysUpdateDate() {
        return sysUpdateDate;
    }

    public void setSysUpdateDate(Date sysUpdateDate) {
        this.sysUpdateDate = sysUpdateDate;
    }
}