package com.example.demo.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
public class UserEntity  {//entity는 DB와만 접촉가능
    //uno,id,password,studentNum,name

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")//3
    private String password;

    @Column(name = "studentnum")//4
    private String studentnum;

    @Column(name = "name")//5
    private String name;
    //private Date wirteDate;

    @Column(name = "authority")//6
    private String authority;


    @Builder
    public UserEntity( String username,String password,String studentnum,String name,String authority){

        this.username=username;
        this.password=password;
        this.studentnum=studentnum;
        this.name=name;
        this.authority=authority;
    }



}
