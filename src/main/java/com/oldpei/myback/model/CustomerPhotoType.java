package com.oldpei.myback.model;


import java.util.Date;

/**
 * @author jixing.pei
 */
public class CustomerPhotoType extends PhotoType {
    private String oldType;

    public CustomerPhotoType() {
        super();
    }

    public CustomerPhotoType(Integer uniqueId, String type, String activeFlg, String sysInsertId, Date sysInsertDate, String sysUpdateId, Date sysUpdateDate) {
        super(uniqueId, type, activeFlg, sysInsertId, sysInsertDate, sysUpdateId, sysUpdateDate);
    }

    public String getOldType() {
        return oldType;
    }

    public void setOldType(String oldType) {
        this.oldType = oldType;
    }
}
