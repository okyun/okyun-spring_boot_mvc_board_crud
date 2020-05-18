package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.repository.BoardRepository;
import com.example.demo.service.repository.HomeworkRepository;
import com.example.demo.service.repository.UserRepository;
import com.example.demo.service.HomeworkService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
public class TestController {
//
//
//    @Autowired
//    private BoardRepository boardRepository;


    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private HomeworkRepository homeworkRepository;
    private HomeworkService homeworkService;
//    @RequestMapping("/board")
//    public List test1(){
//        System.out.println("board");
//        List<BoardEntity> list = boardRepository.findAll();
//
//        return list;
//    }

    @RequestMapping("/userRepository")
    public Optional<UserEntity> userRepository(){
        System.out.println("user");
        Optional<UserEntity> list = userRepository.findByUsername("student");

        return list;
    }
    @RequestMapping("/boardRepository")
    public List<BoardEntity> boardRepository(){
        System.out.println("user");
        List<BoardEntity> list = boardRepository.findByName("일일");

        return list;
    }
//    @RequestMapping("/boardRepository1")
//    public List<BoardEntity> boardRepository1(){
//        System.out.println("user");
//
//
//    }
    @RequestMapping("/homeworkdRepository")
    public List homeworkdRepository(){
        System.out.println("user");
        List<HomeworkDto> list = homeworkService.getAllHomeworklist();

        return list;
    }
    @RequestMapping("/page1")
    public @ResponseBody
    String pageNo1() throws Exception {
        return "Spring Boot : Page No 1";

    }
    @RequestMapping("/page2")
    public @ResponseBody String pageNo2() throws Exception {
        return "Spring Boot : Page No 2";

    }
    @RequestMapping("/username")
    public @ResponseBody String username(Authentication authentication) throws Exception {

        UserDto auth=(UserDto)authentication.getPrincipal();
        return auth.getName();

    }

}

