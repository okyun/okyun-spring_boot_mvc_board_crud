package com.example.demo.domain;


import lombok.*;
import org.omg.CORBA.INTERNAL;

import javax.persistence.*;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "class")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cno")
    private Integer cno;
    @Column(name = "classname")
    private String classname;

    @Builder
    public ClassEntity(Integer cno,String classname){
        this.cno=cno;
        this.classname=classname;
    }

}
