package com.example.demo.controller;

import com.example.demo.CodingComfile.cmd.CCmd;
import com.example.demo.CodingComfile.CFileInOutPut;
import com.example.demo.CodingComfile.cmd.JavaCmd;
import com.example.demo.CodingComfile.JavaFileInOutPut;
import com.example.demo.domain.BoardDto;
import com.example.demo.domain.HomeworkDto;
import com.example.demo.domain.UserDto;
import com.example.demo.service.BoardService;
import com.example.demo.service.HomeworkService;
import com.example.demo.service.UserService;
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
public class BoardController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;
    private UserService userService;
    private HomeworkService homeworkService;



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

        String result = cCmd.execCommand(command);//코드 결과 받아오기

        System.out.println("12121212121212"+result);
        return result;
    }
    @RequestMapping(value="/javaCodingResult", method=RequestMethod.POST)
    @ResponseBody
    public String JavacodingResultPost(BoardDto boardDto){

        CFileInOutPut cFileInOutPut=new CFileInOutPut();//저장
        CCmd cCmd=new CCmd();//컴파일

        cFileInOutPut.Input(boardDto.getContent());//파일저장

        String command = cCmd.inputCommand();//코드 넣고

        String result = cCmd.execCommand(command);//코드 결과 받아오기

        System.out.println("12121212121212"+result);
        return result;
    }
    @RequestMapping(value="/pythonCodingResult", method=RequestMethod.POST)
    @ResponseBody
    public String PythoncodingResultPost(BoardDto boardDto){

        CFileInOutPut cFileInOutPut=new CFileInOutPut();//저장
        CCmd cCmd=new CCmd();//컴파일

        cFileInOutPut.Input(boardDto.getContent());//파일저장

        String command = cCmd.inputCommand();//코드 넣고

        String result = cCmd.execCommand(command);//코드 결과 받아오기

        System.out.println("12121212121212"+result);
        return result;
    }
    @RequestMapping(value="/result", method=RequestMethod.POST)//ajax-c
    @ResponseBody
    public String ResultPost(BoardDto boardDto){
        return boardDto.getTitle();
    }
    @RequestMapping(value="/javacodingResult", method=RequestMethod.POST)//ajax-java
    @ResponseBody
    public String javacodingResultPost(BoardDto boardDto){

        JavaFileInOutPut javaFileInOutPut=new JavaFileInOutPut();//저장
        JavaCmd javaCmd=new JavaCmd();//컴파일

        javaFileInOutPut.Input(boardDto.getContent());//파일저장

        String command = javaCmd.inputCommand();//코드 넣고

        String result = javaCmd.execCommand(command);//코드 결과 받아오기

        System.out.println("34343434343434343"+result);
        return result;
    }
    @GetMapping("/listAll")
    public String list(Model model) {

        List<BoardDto> boardList = boardService.getAllBoardlist();
        model.addAttribute("boardList", boardList);

        return "template/listAll";
    }

    @GetMapping("listAll/{bno}") //게시글 detail 들어가기
    public String detail(@PathVariable("bno")Integer bno, Model model){

        BoardDto boardDto=boardService.getPost(bno);
        model.addAttribute("boardDto", boardDto);

        log.info("888888888888888888"+boardDto.toString());
        return "template/readCoding";
    }
    @GetMapping("/listHomework")
    public String listHomework(Model model) {

        List<HomeworkDto> homeworkList = homeworkService.getAllHomeworklist();
        model.addAttribute("homeworkList", homeworkList);

        return "student/listHomework";
    }
    @GetMapping("/listHomework/{hno}")
    public String detailHomework(@PathVariable("hno")Integer hno,Model model) {

        HomeworkDto homeworkDto = homeworkService.getHomeworkById(hno);

        model.addAttribute("homeworkDto", homeworkDto);

        return "student/readHomework";
    }
    @RequestMapping("/listHomework/{hno}/create")
    public String creatGet1(Model model,@PathVariable("hno")Integer hno){
        HomeworkDto homeworkDto = homeworkService.getHomeworkById(hno);
        model.addAttribute("homeworkDto", homeworkDto);
        //c,java,python으로 페이지 나누기
        if(homeworkDto.getLang().equals("c"))
            return "student/writeCCoding";
        if(homeworkDto.getLang().equals("java"))
            return "student/writeJavaCoding";
        if(homeworkDto.getLang().equals("python"))
            return "student/writePythonCoding";
        else return "student/writeCCoding";


    }

    @RequestMapping(value="/listHomework/{hno}/create", method=RequestMethod.POST)
    public String createPost1(@PathVariable("hno")Integer hno,BoardDto boardDto, Model model,Authentication authentication){
        HomeworkDto homeworkDto = homeworkService.getHomeworkById(hno);
        UserDto auth=(UserDto)authentication.getPrincipal();
        boardDto.setHno(hno);
        boardDto.setLang(homeworkDto.getLang());
        boardDto.setName(auth.getName());
        boardDto.setClassname(homeworkDto.getClassname());
        boardDto.setTeacher(homeworkDto.getName());
        boardDto.setDueday(homeworkDto.getDueday());
        boardService.savePost(boardDto);
        log.info("99999999999999999999999999999"+boardDto.toString());
        return "redirect:/listHomework";
    }
    @GetMapping("/createHomework")//게시글 쓰기
    public String creatHomework(){

        return "template/writeHomework";
    }
    @PostMapping("/createHomework")
    public String postcreatHomework(HomeworkDto homeworkDto,Authentication authentication){
        UserDto auth=(UserDto)authentication.getPrincipal();
        homeworkDto.setName(auth.getName());
        log.info("00000000000000000000000000000"+homeworkDto.toString());
        homeworkService.saveHomework(homeworkDto);


        return "redirect:/teacher/info";
    }



    @GetMapping("/updateHomeworklist")
    public String updateHomeworklist(Model model, Authentication authentication){

        UserDto auth=(UserDto)authentication.getPrincipal();
        List<HomeworkDto> homeworkList=homeworkService.getHomeworkListByName(auth.getName());
        model.addAttribute("homeworkList",homeworkList);
        return "template/updatelist";
    }
    @GetMapping("/updateHomeworklist/{hno}")
    public String updateHomeworkget(Model model, Authentication authentication,@PathVariable("hno")Integer hno){

        HomeworkDto homeworkDto=homeworkService.getHomeworkById(hno);
        model.addAttribute("homeworkDto", homeworkDto);

        return "template/updateHomework";

    }
    @PostMapping("/updateHomeworklist/{hno}")
    public String updateHomeworpost(Model model,HomeworkDto homeworkDto,Authentication authentication,@PathVariable("hno")Integer hno){

        UserDto auth=(UserDto)authentication.getPrincipal();
        homeworkDto.setName(auth.getName());
        homeworkService.saveHomework(homeworkDto);
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+homeworkDto.toString());

        return "redirect:/updateHomeworklist";

    }
    @PostMapping("/updateHomeworklist/delete/{hno}")
    public String deleteHomeworpost(Model model,HomeworkDto homeworkDto,Authentication authentication,@PathVariable("hno")Integer hno){

       homeworkService.deleteHomework(hno);

        return "redirect:/updateHomeworklist";

    }


}
