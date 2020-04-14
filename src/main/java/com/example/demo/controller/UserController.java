package com.example.demo.controller;

import com.example.demo.domain.UserDto;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private UserService userService;


    @GetMapping("/login")//로그인 페이지
    public String loginGet(){
        return "login/login";
    }

    @PostMapping("/login")
    public String loginPost(UserDto userDto, Model model){
        userService.saveUser(userDto);
        model.addAttribute("result","success");//?result=success

        return "redirect:/";
    }

    @GetMapping("/register")//로그인 페이지
    public String registerGet(){
        return "login/register";
    }

    @PostMapping("/register")
    public String registerPost(UserDto userDto, Model model){
        userService.saveUser(userDto);
        log.info("userDto다"+userDto.toString());
        model.addAttribute("result","success");//?result=success

        return "redirect:/login";
    }

}
