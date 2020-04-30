package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bno")
    private Integer bno;

    @Column(name = "title",length = 10,nullable = false)
    private String title;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "contentresult")
    private String contentresult;

    @Column(name = "name",length = 10,nullable = false)
    private String name;
    //private Date wirteDate;

    @Column(name = "classname")
    private String classname;

    @Column(name = "grade")
    private String grade;

    @Column(name = "createdate")
    private LocalDateTime createdate;






    @Builder
    public BoardEntity(Integer bno, String title, String content, String contentresult, String name,String grade,String classname,LocalDateTime createdate) {
        this.bno = bno;
        this.name = name;
        this.title = title;
        this.content = content;
        this.contentresult=contentresult;
        this.grade=grade;
        this.classname=classname;
        this.createdate=createdate;

    }
}
