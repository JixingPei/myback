package com.oldpei.myback.dao;


import com.oldpei.myback.model.CustomerPhotoType;

import java.util.List;

public interface CustomerPhotoTypeMapper extends PhotoTypeMapper {

    List<CustomerPhotoType> getAllPhotoType();

    int addPhotoType(CustomerPhotoType photoType);

    int updatePhotoType(CustomerPhotoType photoType);

    int deletePhotoTypeById(CustomerPhotoType photoType);
}
