package com.oldpei.myback.controller;

import com.oldpei.myback.utils.ConstantCode;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPhotoController {
    @PostMapping("/photo")
    public ModelMap getPhoto(String name) {
        ModelMap model = new ModelMap();
        System.out.println(name);
        model.addAttribute("code",ConstantCode.succeed_code);
        model.addAttribute("msg", "photo");
        return model;
    }



}
