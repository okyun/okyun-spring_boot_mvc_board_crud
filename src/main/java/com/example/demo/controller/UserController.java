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

    // 메인 페이지
    @GetMapping("/index")
    public String index() {
        return "user/index";
    }


    @GetMapping("/login")//로그인 페이지
    public String loginGet(){
        return "user/login";
    }

    @GetMapping("/login/result")//로그인 성공
    public String loginPost(UserDto userDto, Model model){
        userService.saveUser(userDto);
        model.addAttribute("result","success");//?result=success

        return "user/loginSuccess";
    }

    @GetMapping("/register")//회원가입 페이지
    public String registerGet(){
        return "user/register";
    }

    @PostMapping("/register")///회원가입 처리
    public String registerPost(UserDto userDto){
        userService.saveUser(userDto);
        return "redirect:/login";
    }
    @GetMapping("/logout")//로그아웃
    public String logout(){

        return "user/logout";
    }
    @GetMapping("/logout/result")
    public String dispLogout() {
        return "user/logout";
    }
    @GetMapping("/user/info")//마이 페이지
    public String myinfo(){
        return "user/myinfo";
    }
    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "user/admin";
    }


    @GetMapping("/user/denied")// 접근 거부 페이지
    public String dispDenied() {
        return "/denied";
    }

}
