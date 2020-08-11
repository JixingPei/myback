package com.oldpei.myback.model;

import java.util.Date;

public class PhotoType extends BaseModel {
    private Integer uniqueId;

    private String type;

    public PhotoType() {
        super();
    }

    public PhotoType(Integer uniqueId, String type, String activeFlg, String sysInsertId, Date sysInsertDate, String sysUpdateId, Date sysUpdateDate) {
        super(activeFlg, sysInsertId, sysInsertDate, sysUpdateId, sysUpdateDate);
        this.uniqueId = uniqueId;
        this.type = type;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

}