package com.oldpei.myback.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/test")
    public String test() {
        ModelMap model = new ModelMap();
        System.out.println("kaishi");
        model.addAttribute("msg","test");
        return "test";
    }


}
