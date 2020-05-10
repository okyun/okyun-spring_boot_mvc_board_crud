package com.example.demo.domain;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
//정렬 Ctrl + Alt + L
public class BoardDto {

    private Integer bno;

    private Integer hno;
    private String title;
    private String content;
    private String contentresult;
    private String name;
    private String grade;
    private String classname;
    private String lang;
    private LocalDateTime createdate;


    public BoardEntity toEntity(){
        BoardEntity boardEntity= BoardEntity.builder()

                .bno(bno)
                .hno(hno)
                .title(title)
                .content(content)
                .contentresult(contentresult)
                .name(name)
                .grade(grade)
                .classname(classname)
                .createdate(createdate)
                .lang(lang)
                .build();
        return boardEntity;

    }

    @Builder
    public BoardDto(Integer bno,Integer cno,Integer hno,String title,String content,String contentresult,String name,String grade,String classname,LocalDateTime createdate,String lang){
        this.bno=bno;

        this.hno=hno;
        this.title=title;
        this.content=content;
        this.contentresult=contentresult;
        this.name=name;
        this.grade=grade;
        this.classname=classname;
        this.createdate=createdate;
        this.lang=lang;


    }


}
