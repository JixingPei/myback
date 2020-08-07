package com.oldpei.myback.service;

import com.oldpei.myback.model.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PhotoService {
    List<String> getFileDate();

    List<List> getFilePathNamrList(List<String> dateLiat);

    void uploadPhoto(MultipartFile file, Photo photo);

    List<String> getPhotoWall();
}
