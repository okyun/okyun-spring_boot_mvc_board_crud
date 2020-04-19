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
public class UserDto implements UserDetails {//dto는 controller에서만 적촉가능
//uno,id,password,studentNum,name
    private Integer uno;//1
    private String id;//2
    private String password;//3
    private String studentNum;//4
    private String name;//5
    private String authority;//6

    public UserEntity toEntity(){
        UserEntity userEntity= UserEntity.builder()
                .uno(uno)//1
                .id(id)//2
                .password(password)//3
                .studentNum(studentNum)//4
                .name(name)//5
                .authority(authority)//6
                .build();
        return userEntity;

    }

    @Builder
    public UserDto(Integer uno,String id, String password,String studentNum,String name,String authority){
        this.uno=uno;//1
        this.id=id;//2
        this.password=password;//3
        this.studentNum=studentNum;//4
        this.name=name;//5
        this.authority=authority;//6

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(authority));
        return auth;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
