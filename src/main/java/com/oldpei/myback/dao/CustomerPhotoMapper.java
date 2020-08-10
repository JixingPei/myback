package com.oldpei.myback.dao;


import com.oldpei.myback.model.CustomerPhoto;

public interface CustomerPhotoMapper extends PhotoMapper {

    int insertWithoutUniqueId(CustomerPhoto record);

}
