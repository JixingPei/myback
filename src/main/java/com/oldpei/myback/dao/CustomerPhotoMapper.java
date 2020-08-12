package com.oldpei.myback.dao;


import com.oldpei.myback.model.CustomerPhoto;
import com.oldpei.myback.model.CustomerPhotoType;

import java.util.List;

public interface CustomerPhotoMapper extends PhotoMapper {

    int insertWithoutUniqueId(CustomerPhoto record);

    List<CustomerPhoto> getAllPhoto();

    int updateTypeOfPhoto(CustomerPhoto photoType);

    List<CustomerPhoto> getPhotoByType(String type);
}
