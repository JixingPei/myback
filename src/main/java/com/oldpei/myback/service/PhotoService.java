package com.oldpei.myback.service;

import com.oldpei.myback.model.CustomerPhoto;
import com.oldpei.myback.model.CustomerPhotoType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface PhotoService {
    List<String> getFileDate();

    List<List> getFilePathNamrList(List<String> dateList);

    int uploadPhoto(MultipartFile file, CustomerPhoto photo);

    List<String> getPhotoWall();

    int insertWithoutUniqueId(CustomerPhoto record);

    List<CustomerPhoto> getAllPhoto();

    Map<String, List<CustomerPhoto>> orderByType(List<CustomerPhoto> photoList);

    int updateTypeOfPhoto(CustomerPhoto photo);

    int deletePhotoByType(String type);
}
