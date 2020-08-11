package com.oldpei.myback.controller;

import com.oldpei.myback.model.CustomerPhoto;
import com.oldpei.myback.model.ResultModel;
import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.utils.CommonUtils;
import com.oldpei.myback.utils.ConstantCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PhotoController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(PhotoController.class);

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photowall")
    public ModelMap getPhotoWall() {
        ModelMap model = new ModelMap();
        List<String> filePathNameList = photoService.getPhotoWall();
        model.addAttribute("code", ConstantCode.SUCCEED_CODE);
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
        model.addAttribute("code", ConstantCode.SUCCEED_CODE);
        model.addAttribute("dateList", dateList);
        model.addAttribute("filePathNameList", filePathNameList);
        return model;
    }

    @PostMapping("/uploadPhoto")
    public ResultModel uploadPhoto(@RequestParam("file") MultipartFile file, CustomerPhoto photo) {
        ResultModel model = new ResultModel();
        model.setCode(ConstantCode.SUCCEED_CODE);
        logger.info(""+photoService.uploadPhoto(file, photo));
        return model;
    }

    @GetMapping("/typePhoto")
    public ModelMap getAllPhoto() {
        ModelMap model = new ModelMap();
        List<CustomerPhoto> photoList =photoService.getAllPhoto();
        Map<String ,List<CustomerPhoto>> map = photoService.orderByType(photoList);
        model.addAttribute("code",ConstantCode.SUCCEED_CODE);
        model.addAttribute("map",map);
        return model;
    }


}
