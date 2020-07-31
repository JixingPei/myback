package com.oldpei.myback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/photo")
    public ModelMap index() {
        ModelMap model = new ModelMap();
        System.out.println("kaishi");
        model.addAttribute("msg","test");
        return model;
    }
    @GetMapping("/test")
    public String test() {
        ModelMap model = new ModelMap();
        System.out.println("kaishi");
        model.addAttribute("msg","test");
        return "test";
    }


}
