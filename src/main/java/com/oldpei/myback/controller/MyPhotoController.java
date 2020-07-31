package com.oldpei.myback.controller;

import com.oldpei.myback.service.PhotoService;
import com.oldpei.myback.utils.CommonUtils;
import com.oldpei.myback.utils.ConstantCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyPhotoController {

    @Autowired
    PhotoService photoService;

    @PostMapping("/photo")
    public ModelMap getPhoto(String name) {
        ModelMap model = new ModelMap();
        List<String> dateLiat = photoService.getFileDate();
        if (CommonUtils.listNonNull(dateLiat)){

        }else{
            model.addAttribute("code", 0);
            return model;
        }

        model.addAttribute("code", ConstantCode.succeed_code);
        return model;
    }


}
