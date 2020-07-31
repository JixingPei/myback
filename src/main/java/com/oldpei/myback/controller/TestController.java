package com.oldpei.myback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/")
    public ModelMap all() {
        ModelMap model = new ModelMap();
        System.out.println("all");
        model.addAttribute("msg","all");
        return model;
    }

    @PostMapping("/photo")
    public ModelMap index() {
        ModelMap model = new ModelMap();
        System.out.println("kaishi");
        model.addAttribute("msg","photo");
        return model;
    }
    @PostMapping("/test")
    public String test() {
        ModelMap model = new ModelMap();
        System.out.println("kaishi");
        model.addAttribute("msg","test");
        return "test";
    }


}
