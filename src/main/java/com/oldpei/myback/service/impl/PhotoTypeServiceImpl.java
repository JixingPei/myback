package com.oldpei.myback.service.impl;


import com.oldpei.myback.dao.CustomerPhotoTypeMapper;
import com.oldpei.myback.model.CustomerPhotoType;
import com.oldpei.myback.service.PhotoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PhotoTypeServiceImpl implements PhotoTypeService {
    @Autowired
    private CustomerPhotoTypeMapper photoTypeMapper;

    @Override
    public List<CustomerPhotoType> getAllPhotoType() {
        return photoTypeMapper.getAllPhotoType();
    }

    @Override
    public int addPhotoType(CustomerPhotoType photoType) {
        return photoTypeMapper.addPhotoType(photoType);
    }
}
