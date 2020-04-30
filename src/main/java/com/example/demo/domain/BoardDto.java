package com.example.demo.domain;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
//정렬 Ctrl + Alt + L
public class BoardDto {

    private Integer bno;
    private String title;
    private String content;
    private String contentresult;
    private String name;
    private String grade;
    private String classname;
    private LocalDateTime createdate;

    public BoardEntity toEntity(){
        BoardEntity boardEntity= BoardEntity.builder()
                .bno(bno)
                .title(title)
                .content(content)
                .contentresult(contentresult)
                .name(name)
                .grade(grade)
                .classname(classname)
                .createdate(createdate)
                .build();
        return boardEntity;

    }

    @Builder
    public BoardDto(Integer bno,String title,String content,String contentresult,String name,String grade,String classname,LocalDateTime createdate){
        this.bno=bno;
        this.title=title;
        this.content=content;
        this.contentresult=contentresult;
        this.name=name;
        this.grade=grade;
        this.classname=classname;
        this.createdate=createdate;


    }


}
