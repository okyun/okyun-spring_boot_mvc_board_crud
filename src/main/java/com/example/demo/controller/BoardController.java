package com.example.demo.controller;

import com.example.demo.CodingComfile.CCmd;
import com.example.demo.CodingComfile.CFileInOutPut;
import com.example.demo.domain.BoardDto;
import com.example.demo.domain.UserDto;
import com.example.demo.service.BoardService;
import com.example.demo.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;
    private UserService userService;

    @GetMapping("/listAll")
    public String list(Model model) {

        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);

        return "template/listAll.html";
    }

    @GetMapping("/codemirror")//게시글 쓰기
    public String codemirror(){
        return "template/codeMirror";
    }

    @GetMapping("/create")//게시글 쓰기
    public String creatGet(){

        return "template/writeCoding";
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String createPost(BoardDto boardDto, Model model,Authentication authentication){
        UserDto auth=(UserDto)authentication.getPrincipal();
        boardDto.setName(auth.getName());
        boardService.savePost(boardDto);
        model.addAttribute("result","success");//?result=success
        return "redirect:/listAll";//url: http://localhost:9090/listAll로 이동하기
    }
    ///codingResult

    @RequestMapping(value="/codingResult", method=RequestMethod.POST)
    @ResponseBody
    public String codingResultPost(BoardDto boardDto){

        CFileInOutPut cFileInOutPut=new CFileInOutPut();//저장
        CCmd cCmd=new CCmd();//컴파일

        cFileInOutPut.Input(boardDto.getContent());//파일저장

        String command = cCmd.inputCommand();//코드 넣고
////        //2.
        String result = cCmd.execCommand(command);//코드 결과 받아오기
////
        System.out.println(result);


        return result;
    }

    @GetMapping("listAll/{bno}") //게시글 detail 들어가기
    public String detail(@PathVariable("bno")Integer bno, Model model){

        BoardDto boardDto=boardService.getPost(bno);
        model.addAttribute("boardDto", boardDto);

        log.info("888888888888888888"+boardDto.toString());
        return "template/readCoding";
    }





}
