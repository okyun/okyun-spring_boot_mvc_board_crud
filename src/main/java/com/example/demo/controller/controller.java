package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class controller {

    @RequestMapping(value="/")     // localhost
    public String root() {
        return "/template/index";         // 실제 호출될 /WEB-INF/jsp/index.jsp
    }



    @RequestMapping(value="/login")     // localhost
    public String login() {
        return "/user/login";         // 실제 호출될 /WEB-INF/jsp/index.jsp
    }






  }