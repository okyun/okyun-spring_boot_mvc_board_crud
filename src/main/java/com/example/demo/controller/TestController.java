package com.example.demo.controller;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.repository.BoardRepository;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
//
//
//    @Autowired
//    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;





//    @RequestMapping("/board")
//    public List test1(){
//        System.out.println("board");
//        List<BoardEntity> list = boardRepository.findAll();
//
//        return list;
//    }

    @RequestMapping("/userRepository")
    public List userRepository(){
        System.out.println("board");
        List<UserEntity> list = userRepository.findAll();

        return list;
    }





}

