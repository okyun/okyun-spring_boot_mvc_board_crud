package com.example.demo.controller;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.HomeworkDto;
import com.example.demo.domain.UserDto;
import com.example.demo.service.BoardService;
import com.example.demo.service.HomeworkService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class InfoController {

    private HomeworkService homeworkService;
    private BoardService boardService;
    @RequestMapping("/teacher/info")//기본 화면
    public String teacherinfo(Model model, Authentication authentication){
        UserDto auth=(UserDto)authentication.getPrincipal();
        List<HomeworkDto> homeworkList=homeworkService.getHomeworkListByName(auth.getName());
        model.addAttribute("homeworkList",homeworkList);

        return "myinfo/teacherInfo";
    }
    @RequestMapping("/student/info")//기본 화면
    public String studentinfo(Model model,Authentication authentication){
        UserDto auth=(UserDto)authentication.getPrincipal();
        List<BoardDto> boardList=boardService.getBoardListByName(auth.getName());
        model.addAttribute("boardList",boardList);

        return "myinfo/studentInfo";
    }
}
