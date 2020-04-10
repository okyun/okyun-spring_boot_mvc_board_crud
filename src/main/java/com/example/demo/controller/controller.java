package com.example.demo.controller;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.UserDto;
import com.example.demo.domain.repository.BoardRepository;
import com.example.demo.service.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@AllArgsConstructor
public class controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    private BoardService boardService;

    @GetMapping("/test")
    public String getUser(Model model) {
        UserDto user = new UserDto("kkaok", "테스트", "web") ;
        model.addAttribute("user", user);
        return "test";
    }


  }