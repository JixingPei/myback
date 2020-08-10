package com.oldpei.myback.controller;

import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.utils.CommonUtils;
import com.oldpei.myback.utils.constant.ConstantCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyPhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/photowall")
    public ModelMap getPhotoWall() {
        ModelMap model = new ModelMap();
        List<String> filePathNameList = photoService.getPhotoWall();
        model.addAttribute("code", ConstantCode.succeed_code);
        model.addAttribute("filePathNameList", filePathNameList);
        return model;
    }


    @GetMapping("/photo")
    public ModelMap getPhoto() {
        ModelMap model = new ModelMap();
        List<String> dateList = photoService.getFileDate();
        List<List> filePathNameList = new ArrayList<>();
        if (CommonUtils.listNonNull(dateList)) {
            filePathNameList = photoService.getFilePathNamrList(dateList);
        }
        model.addAttribute("code", ConstantCode.succeed_code);
        model.addAttribute("dateList", dateList);
        model.addAttribute("filePathNameList", filePathNameList);
        return model;
    }

    @PostMapping("/uploadPhoto")
    public ModelMap uploadPhoto(@RequestParam("file") MultipartFile file, Photo photo) {
        photoService.uploadPhoto(file, photo);
        ModelMap model = new ModelMap();
        model.addAttribute("code", ConstantCode.succeed_code);
        return model;
    }


}
