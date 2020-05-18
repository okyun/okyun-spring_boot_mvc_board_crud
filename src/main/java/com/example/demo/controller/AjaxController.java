package com.example.demo.controller;

import com.example.demo.CodingComfile.CFileInOutPut;
import com.example.demo.CodingComfile.JavaFileInOutPut;
import com.example.demo.CodingComfile.cmd.CCmd;
import com.example.demo.CodingComfile.cmd.JavaCmd;
import com.example.demo.domain.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class AjaxController {
    @RequestMapping(value="/codingResult", method= RequestMethod.POST)
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
}
