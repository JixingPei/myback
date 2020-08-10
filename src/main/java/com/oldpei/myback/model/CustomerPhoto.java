package com.oldpei.myback.model;

import com.oldpei.myback.utils.publicTools.CommonUtils;

import java.util.Date;
import java.util.Objects;

/**
 * @author jixing.pei
 */
public class CustomerPhoto extends Photo {
    public CustomerPhoto(Integer uniqueId, String date, String type, String name, String path, String activeFlg, String sysInsertId, Date sysInsertDate, String sysUpdateId, Date sysUpdateDate) {
        super(uniqueId, date, type, name, path, activeFlg, sysInsertId, sysInsertDate, sysUpdateId, sysUpdateDate);
        if (CommonUtils.strIsEmpty(activeFlg)) {
            this.setActiveFlg("1");
        }
        if (CommonUtils.strIsEmpty(sysInsertId)) {
            this.setSysInsertId("System");
        }
        if (CommonUtils.strIsEmpty(sysUpdateId)) {
            this.setSysUpdateId("System");
        }
        if (Objects.isNull(sysInsertDate)) {
            this.setSysInsertDate(new Date());
        }
        if (Objects.isNull(sysUpdateDate)) {
            this.setSysUpdateDate(new Date());
        }
    }

}
