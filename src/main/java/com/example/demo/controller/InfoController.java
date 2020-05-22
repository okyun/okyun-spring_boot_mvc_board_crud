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
        //HomeworkDto homework=homeworkList.get(0);
        model.addAttribute("homeworkList",homeworkList);
       // model.addAttribute("homework",homework);
       // log.info("888888888888888888classname:"+homework);
        return "myinfo/teacherInfo";
    }
    @RequestMapping("/teacher/info/{hno}") //숙제list
    public String hnolist(@PathVariable("hno")Integer hno, Model model){
        List<BoardDto>boardList=boardService.getBoardListByHno(hno);

        model.addAttribute("boardList", boardList);



        //log.info("888888888888888888"+boardDto.toString());
        return "myinfo/listhno";
    }
    @RequestMapping("/teacher/info/{hno}/{bno}") //숙제list
    public String hnolistdetail(@PathVariable("hno")Integer hno, @PathVariable("bno")Integer bno,Model model){
        BoardDto boardDto=boardService.getPost(bno);
        HomeworkDto homeworkDto=homeworkService.getHomeworkById(hno);

        model.addAttribute("boardDto", boardDto);
        model.addAttribute("homeworkDto", homeworkDto);

        if(homeworkDto.getLang().equals("c"))
            return "myinfo/readCCoding";
        if(homeworkDto.getLang().equals("java"))
            return "myinfo/readJavaCoding";
        if(homeworkDto.getLang().equals("python"))
            return "myinfo/readPythonCoding";
        else return "myinfo/readCCoding";

        //log.info("888888888888888888"+boardDto.toString());

    }
    @PostMapping("/teacher/info/{hno}/{bno}")//점수주기
    public String Postgrade(@PathVariable("bno")Integer bno,BoardDto boardDto,Authentication authentication){

        UserDto auth=(UserDto)authentication.getPrincipal();
        HomeworkDto homeworkDto = homeworkService.getHomeworkById(boardDto.getHno());

        boardDto.setStudentnum(auth.getStudentnum());

        boardService.savePost(boardDto);
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+boardDto.toString());

        return "redirect:/teacher/info/{hno}";
    }

    @RequestMapping("/student/info")//기본 화면
    public String studentinfo(Model model,Authentication authentication){
        UserDto auth=(UserDto)authentication.getPrincipal();
        List<BoardDto> boardList=boardService.getBoardListByName(auth.getName());
        model.addAttribute("boardList",boardList);
        model.addAttribute("auth",auth);


        return "myinfo/studentInfo";
    }
    @GetMapping("/student/info/{bno}") //게시글 수정하기-update1
    public String detail(@PathVariable("bno")Integer bno, Model model){

        BoardDto boardDto=boardService.getPost(bno);
        HomeworkDto homeworkDto = homeworkService.getHomeworkById(boardDto.getHno());
        model.addAttribute("homeworkDto", homeworkDto);
        model.addAttribute("boardDto", boardDto);
        if(boardDto.getLang().equals("c"))
            return "student/updateCCoding";
        if(boardDto.getLang().equals("java"))
            return "student/updateJavaCoding";
        if(boardDto.getLang().equals("python"))
            return "student/updatePythonCoding";
        else  return "student/updateCCoding";
       // return "template/updateCoding";
    }
    @PostMapping("/student/info/{bno}")//게시글 수정하기-update2
    public String updatePost(@PathVariable("bno")Integer bno,BoardDto boardDto,Authentication authentication){

        UserDto auth=(UserDto)authentication.getPrincipal();
        HomeworkDto homeworkDto = homeworkService.getHomeworkById(boardDto.getHno());
        boardDto.setName(auth.getName());

        boardService.savePost(boardDto);
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+boardDto.toString());

        return "redirect:/student/info";
    }

    @PostMapping("/student/info/delete/{bno}")//게시글 수정하기-update2
    public String deletePost(@PathVariable("bno")Integer bno,BoardDto boardDto,Authentication authentication){

        boardService.deletePost(bno);
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+boardDto.toString());

        return "redirect:/student/info";
    }





}
