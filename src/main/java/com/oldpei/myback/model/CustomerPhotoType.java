package com.oldpei.myback.model;

import com.oldpei.myback.utils.publicTools.CommonUtils;

import java.util.Date;
import java.util.Objects;

/**
 * @author jixing.pei
 */
public class CustomerPhotoType extends PhotoType {
    public CustomerPhotoType(Integer uniqueId, String type, String activeFlg, String sysInsertId, Date sysInsertDate, String sysUpdateId, Date sysUpdateDate) {
        super();
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
