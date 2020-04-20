package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
public class UserEntity {//entity는 DB와만 접촉가능
    //uno,id,password,studentNum,name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//2
    @Column(name = "id",length = 10,nullable = false)
    private String id;

    @Column(name = "uno")//1
    private Integer uno;



    @Column(name = "password",length = 10,nullable = false)//3
    private String password;

    @Column(name = "studentNum",length = 10,nullable = false)//4
    private String studentNum;

    @Column(name = "name",length = 10,nullable = false)//5
    private String name;
    //private Date wirteDate;

    @Column(name = "authority",length = 10,nullable = false)//6
    private String authority;

    @Builder
    public UserEntity(Integer uno, String id,String password,String studentNum,String name,String authority){
        this.uno=uno;
        this.id=id;
        this.password=password;
        this.studentNum=studentNum;
        this.name=name;
        this.authority=authority;
    }


}
