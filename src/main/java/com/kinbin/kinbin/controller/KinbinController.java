package com.kinbin.kinbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KinbinController {

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

}
