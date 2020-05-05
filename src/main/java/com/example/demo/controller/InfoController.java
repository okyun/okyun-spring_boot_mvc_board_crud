package com.example.demo.controller;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.HomeworkDto;
import com.example.demo.domain.UserDto;
import com.example.demo.service.BoardService;
import com.example.demo.service.HomeworkService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class InfoController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private HomeworkService homeworkService;
    private BoardService boardService;
    @RequestMapping("/teacher/info")//기본 화면
    public String teacherinfo(Model model, Authentication authentication){
        UserDto auth=(UserDto)authentication.getPrincipal();
        List<HomeworkDto> homeworkList=homeworkService.getHomeworkListByName(auth.getName());
        model.addAttribute("homeworkList",homeworkList);

        return "myinfo/teacherInfo";
    }
    @RequestMapping("/teacher/info/{hno}") //숙제list
    public String hnolist(@PathVariable("hno")Integer hno, Model model){
        List<BoardDto>boardList=boardService.getBoardListByHno(hno);

        model.addAttribute("boardList", boardList);

        //log.info("888888888888888888"+boardDto.toString());
        return "myinfo/listhno";
    }
    @RequestMapping("/student/info")//기본 화면
    public String studentinfo(Model model,Authentication authentication){
        UserDto auth=(UserDto)authentication.getPrincipal();
        List<BoardDto> boardList=boardService.getBoardListByName(auth.getName());
        model.addAttribute("boardList",boardList);
        model.addAttribute("auth",auth);


        return "myinfo/studentInfo";
    }
    @GetMapping("/student/info/{bno}") //게시글 수정하기
    public String detail(@PathVariable("bno")Integer bno, Model model){

        BoardDto boardDto=boardService.getPost(bno);
        model.addAttribute("boardDto", boardDto);

        //log.info("888888888888888888"+boardDto.toString());
        return "template/updateCoding";
    }
    @PostMapping("/student/info/{bno}")
    public String updatePost(@PathVariable("bno")Integer bno,BoardDto boardDto,Authentication authentication){

        UserDto auth=(UserDto)authentication.getPrincipal();
        boardDto.setName(auth.getName());
        boardService.savePost(boardDto);
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+boardDto.toString());

        return "redirect:/student/info";
    }





}
