package com.example.demo.controller;

import com.example.demo.domain.UserDto;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


    @GetMapping("user/login")//로그인 페이지
    public String loginGet(){
        return "user/login.html";
    }


    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "user/loginS";
    }

    @GetMapping("user/register")//회원가입 페이지
    public String registerGet(){
        return "user/register";
    }

    @PostMapping("user/register")///회원가입 처리
    public String registerPost(UserDto userDto){
        userService.saveUser(userDto);
        log.info("아 여기는 registerPost!!!!!!!!!!");
        return "redirect:/";
    }
    @GetMapping("user/logout")//로그아웃
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
        return "user/denied";
    }

}
