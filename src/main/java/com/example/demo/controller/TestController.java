package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {


    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user")
    public List  test(){
        System.out.println("user");
        List<UserDto> list = userRepository.findAll();

        return list;
    }

    @RequestMapping("/board")
    public List  test1(){
        System.out.println("board");
        List<BoardDto> list = boardRepository.findAll();

        return list;
    }



}

