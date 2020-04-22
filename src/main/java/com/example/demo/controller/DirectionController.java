package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirectionController {
////////////////////게시판
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

    @RequestMapping("/read/readCoding")
    public String readCoding(){
        return "template/readCoding1";
    }

    @RequestMapping("/updateCoding")
    public String updateCoding(){
        return "template/updateCoding";
    }


    ////////////////////sep


    @RequestMapping("/header")
    public String header(){
        return "sep/index_header_menu";
    }

    @RequestMapping("/footer")
    public String footer(){
        return "sep/index_footer";
    }
    @RequestMapping("/index")
    public String testindex(){
        return "indexTest";
    }

}
