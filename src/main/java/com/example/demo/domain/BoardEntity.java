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



    @Column(name = "hno")
    private Integer hno;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "contentresult")
    private String contentresult;

    @Column(name = "name")
    private String name;
    //private Date wirteDate;

    @Column(name = "classname")
    private String classname;

    @Column(name = "grade")
    private String grade;

    @Column(name = "createdate")
    private LocalDateTime createdate;

    @Column(name = "lang")
    private String lang;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "dueday")
    private String dueday;

    @Column(name = "studentnum")
    private String studentnum;
    @Builder
    public BoardEntity(Integer bno, Integer hno,String title, String content, String contentresult, String name,String grade,String classname,LocalDateTime createdate,String lang,String teacher,String dueday,String studentnum) {
        this.bno = bno;
        this.hno=hno;

        this.name = name;
        this.title = title;
        this.content = content;
        this.contentresult=contentresult;
        this.grade=grade;
        this.classname=classname;
        this.createdate=createdate;
        this.lang=lang;
        this.teacher=teacher;
        this.dueday=dueday;
        this.studentnum=studentnum;
    }
}
