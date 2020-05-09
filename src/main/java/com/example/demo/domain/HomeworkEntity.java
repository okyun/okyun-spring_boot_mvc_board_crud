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


    @Column(name = "classname")
    private String classname;

    @Column(name = "dueday")
    private String dueday;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "des")
    private String des;

    @Column(name = "lang")
    private String lang;

    @Builder
    public HomeworkEntity(Integer hno,String name,String classname,String dueday,String title,String content,String des,String lang){
        this.hno=hno;
        this.name=name;

        this.classname=classname;
        this.dueday=dueday;
        this.des=des;
        this.title=title;
        this.content=content;
        this.lang=lang;

    }



}
