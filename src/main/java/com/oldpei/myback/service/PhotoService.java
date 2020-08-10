package com.oldpei.myback.service;

import com.oldpei.myback.model.CustomerPhoto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PhotoService {
    List<String> getFileDate();

    List<List> getFilePathNamrList(List<String> dateList);

    int uploadPhoto(MultipartFile file, CustomerPhoto photo);

    List<String> getPhotoWall();

    int insertWithoutUniqueId(CustomerPhoto record);

}
