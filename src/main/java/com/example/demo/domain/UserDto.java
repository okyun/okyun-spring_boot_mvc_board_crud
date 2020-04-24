package com.example.demo.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


@ToString
@Getter
@Setter
public class UserDto {//dto는 controller에서만 적촉가능
//uno,id,password,studentNum,name

    private String username;//2
    private String password;//3
    private String studentnum;//4
    private String name;//5
    private String authority;//6

    public UserEntity toEntity(){
        UserEntity userEntity= UserEntity.builder()
                .username(username)//2
                .password(password)//3
                .studentnum(studentnum)//4
                .name(name)//5
                .authority(authority)//6
                .build();
        return userEntity;

    }

    @Builder
    public UserDto(String username, String password,String studentnum,String name,String authority){
        this.username=username;//2
        this.password=password;//3
        this.studentnum=studentnum;//4
        this.name=name;//5
        this.authority=authority;//6

    }



}
