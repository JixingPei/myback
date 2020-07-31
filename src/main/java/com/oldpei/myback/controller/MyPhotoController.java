package com.oldpei.myback.controller;

import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.utils.CommonUtils;
import com.oldpei.myback.utils.ConstantCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyPhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/photo")
    public ModelMap getPhoto() {
        ModelMap model = new ModelMap();
        List<String> dateList = photoService.getFileDate();
        List<List> filePathNamrList = new ArrayList<>();
        if (CommonUtils.listNonNull(dateList)) {
            filePathNamrList = photoService.getFilePathNamrList(dateList);
        }
        model.addAttribute("code", ConstantCode.succeed_code);
        model.addAttribute("dateList", dateList);
        model.addAttribute("filePathNamrList", filePathNamrList);
        return model;
    }


}
