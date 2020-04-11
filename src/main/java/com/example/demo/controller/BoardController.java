package com.example.demo.controller;

import com.example.demo.domain.BoardDto;
import com.example.demo.service.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;

    @GetMapping("/listAll")
    public String list(Model model) {

        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);

        return "template/listAll";
    }

    @GetMapping("/create")
    public String creatGet(){
        return "write";
    }

    @PostMapping("/create")
    public String createPost(BoardDto boardDto,Model model){

        boardService.savePost(boardDto);
        model.addAttribute("result","success");//?result=success
        return "redirect:/listAll";//url: http://localhost:9090/listAll로 이동하기
    }
    


}
