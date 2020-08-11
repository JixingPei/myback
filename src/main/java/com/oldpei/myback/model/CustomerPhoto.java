package com.oldpei.myback.model;

import java.util.Date;

/**
 * @author jixing.pei
 */
public class CustomerPhoto extends Photo {

    private String oldType;



    public CustomerPhoto(Integer uniqueId, String date, String type, String name, String path, String activeFlg, String sysInsertId, Date sysInsertDate, String sysUpdateId, Date sysUpdateDate) {
        super(uniqueId, date, type, name, path, activeFlg, sysInsertId, sysInsertDate, sysUpdateId, sysUpdateDate);
    }

    public CustomerPhoto() {
        super();
    }

    public String getOldType() {
        return oldType;
    }

    public void setOldType(String oldType) {
        this.oldType = oldType;
    }
}
