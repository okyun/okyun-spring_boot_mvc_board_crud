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
    private String writer;
    private String grade;
    private String classname;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        BoardEntity boardEntity= BoardEntity.builder()
                .bno(bno)
                .title(title)
                .content(content)
                .writer(writer)
                .grade(grade)
                .classname(classname)
                .build();
        return boardEntity;

    }

    @Builder
    public BoardDto(Integer bno,String title,String content,String writer,String grade,String classname,LocalDateTime createdDate,LocalDateTime modifiedDate){
        this.bno=bno;
        this.title=title;
        this.content=content;
        this.writer=writer;
        this.grade=grade;
        this.classname=classname;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }


}
