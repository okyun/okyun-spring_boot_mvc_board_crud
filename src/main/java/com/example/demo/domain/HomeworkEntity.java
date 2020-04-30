package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "homework")
public class HomeworkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hno")
    private Integer hno;

    @Column(name = "name")
    private String name;

    @Column(name = "cno")
    private Integer cno;

    @Column(name = "classname")
    private String classname;

    @Column(name = "dueday")
    private String dueday;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Builder
    public HomeworkEntity(Integer hno,String name,Integer cno,String classname,String dueday,String title,String content){
        this.hno=hno;
        this.name=name;
        this.cno=cno;
        this.classname=classname;
        this.dueday=dueday;
        this.title=title;
        this.content=content;

    }



}
