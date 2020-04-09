package com.example.demo.controller;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.UserDto;
import com.example.demo.domain.repository.BoardRepository;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class controller {


    @Autowired
    private BoardService boardService;

    @RequestMapping(value="/")     // localhost
    public String root() {
        return "/template/index";         // 실제 호출될 /WEB-INF/jsp/index.jsp
    }



    @RequestMapping(value="/login")     // localhost
    public String login() {
        return "/user/login";         // 실제 호출될 /WEB-INF/jsp/index.jsp
    }

    @RequestMapping("/writeTest")
    public String write(BoardDto boardDto) {
        boardDto.setTitle("내가 제목이당");
        boardDto.setContent("내가 제목이당");
        boardDto.setWriter("작가지롱");
        boardService.savePost(boardDto);
        return "index";
    }







  }