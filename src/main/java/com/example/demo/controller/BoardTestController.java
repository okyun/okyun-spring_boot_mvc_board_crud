package com.example.demo.controller;

import com.example.demo.service.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class BoardTestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;


}
