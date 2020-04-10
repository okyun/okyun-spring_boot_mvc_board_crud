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
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        BoardEntity boardEntity= BoardEntity.builder()
                .bno(bno)
                .title(title)
                .content(content)
                .writer(writer)
                .build();
        return boardEntity;

    }

    @Builder
    public BoardDto(Integer bno,String title,String content,String writer,LocalDateTime createdDate,LocalDateTime modifiedDate){
        this.bno=bno;
        this.title=title;
        this.content=content;
        this.writer=writer;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }


}
