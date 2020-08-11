package com.oldpei.myback.model;

import com.oldpei.myback.utils.CommonUtils;

import java.util.Date;
import java.util.Objects;

public class BaseModel {
    private String activeFlg = "1";

    private String sysInsertId = "System";

    private Date sysInsertDate = new Date();

    private String sysUpdateId = "System";

    private Date sysUpdateDate = new Date();

    public BaseModel() {
        super();
    }

    public BaseModel(String activeFlg, String sysInsertId, Date sysInsertDate, String sysUpdateId, Date sysUpdateDate) {


        if (CommonUtils.strIsEmpty(activeFlg)) {
            this.activeFlg = "1";
        } else {
            this.activeFlg = activeFlg;
        }
        if (CommonUtils.strIsEmpty(sysInsertId)) {
            this.sysInsertId = "System";
        } else {
            this.sysInsertId = sysInsertId;
        }
        if (CommonUtils.strIsEmpty(sysUpdateId)) {
            this.sysUpdateId = "System";
        } else {
            this.sysInsertDate = sysInsertDate;
        }
        if (Objects.isNull(sysInsertDate)) {
            this.sysInsertDate = new Date();
        } else {
            this.sysUpdateId = sysUpdateId;
        }
        if (Objects.isNull(sysUpdateDate)) {
            this.sysUpdateDate = new Date();
        } else {
            this.sysUpdateDate = sysUpdateDate;
        }
    }

    public String getActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(String activeFlg) {
        this.activeFlg = activeFlg;
    }

    public String getSysInsertId() {
        return sysInsertId;
    }

    public void setSysInsertId(String sysInsertId) {
        this.sysInsertId = sysInsertId;
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
        this.sysUpdateId = sysUpdateId;
    }

    public Date getSysUpdateDate() {
        return sysUpdateDate;
    }

    public void setSysUpdateDate(Date sysUpdateDate) {
        this.sysUpdateDate = sysUpdateDate;
    }
}
