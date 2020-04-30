package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "name",length = 10,nullable = false)
    private String name;
    //private Date wirteDate;

    @Column(name = "classname")
    private String classname;

    @Column(name = "grade")
    private String grade;








    @Builder
    public BoardEntity(Integer bno, String title, String content, String name,String grade,String classname) {
        this.bno = bno;
        this.name = name;
        this.title = title;
        this.content = content;
        this.grade=grade;
        this.classname=classname;

    }
}
