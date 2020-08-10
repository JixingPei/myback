package com.oldpei.myback.service;

import com.oldpei.myback.model.CustomerPhotoType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhotoTypeService {
    List<CustomerPhotoType> getAllPhotoType();

    int addPhotoType(CustomerPhotoType photoType);
}
