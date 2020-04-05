package com.example.demo.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardDto extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bno")
    private Integer bno;

    @Column(name = "title",length = 10,nullable = false)
    private String title;

    @Column(name = "content",columnDefinition = "TEXT",nullable = false)
    private String content;

    @Column(name = "writer",length = 10,nullable = false)
    private String writer;
    //private Date wirteDate;

    @Builder
    public BoardDto(Integer bno, String title, String content, String writer) {
        this.bno = bno;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }




}
