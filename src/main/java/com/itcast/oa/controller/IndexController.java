package com.itcast.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/left.html")
    public String left(){
        return "left";
    }
    @RequestMapping("/right.html")
    public String right(){
        return "right";
    }
    @RequestMapping("/top.html")
    public String top(){
        return "top";
    }
}
