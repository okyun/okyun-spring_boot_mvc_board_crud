package com.example.demo.controller;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {


    @Autowired
    private BoardRepository boardRepository;




    @RequestMapping("/board")
    public List test1(){
        System.out.println("board");
        List<BoardEntity> list = boardRepository.findAll();

        return list;
    }





}

