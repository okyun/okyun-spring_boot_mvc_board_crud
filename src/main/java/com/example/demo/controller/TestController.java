package com.example.demo.controller;

import com.example.demo.config.UserRepository;
import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user")
    public List  test(){
        System.out.println("aaaa");
        List<UserDto> list = userRepository.findAll();

        return list;
    }



}

