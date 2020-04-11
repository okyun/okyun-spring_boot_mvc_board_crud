package com.example.demo.controller;

import com.example.demo.domain.BoardEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DirectionController {

    @RequestMapping("/")//기본 화면
    public String home(){
        return "template/index";
    }
    @RequestMapping("/codemirror")//기본 화면
    public String codemirror(){
        return "index1";
    }

    @RequestMapping("/writeCoding")
    public String writeCoding(){
        return "template/writeCoding";
    }

    @RequestMapping("/readCoding")
    public String readCoding(){
        return "template/readCoding";
    }



}
