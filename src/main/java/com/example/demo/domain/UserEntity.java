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

    @Column(name = "uno")
    private Integer uno;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 10,nullable = false)
    private String id;

    @Column(name = "password",length = 10,nullable = false)
    private String password;

    @Column(name = "studentNum",length = 10,nullable = false)
    private String studentNum;

    @Column(name = "name",length = 10,nullable = false)
    private String name;
    //private Date wirteDate;

    @Column(name = "role",length = 10,nullable = false)
    private String role;

    @Builder
    public UserEntity(Integer uno, String id,String password,String studentNum,String name,String role){
        this.uno=uno;
        this.id=id;
        this.password=password;
        this.studentNum=studentNum;
        this.name=name;
        this.role=role;
    }


}
