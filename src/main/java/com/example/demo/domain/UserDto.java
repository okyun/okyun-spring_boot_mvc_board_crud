package com.example.demo.domain;

import lombok.*;


@ToString
@Getter
@Setter
public class UserDto {//dto는 controller에서만 적촉가능
//uno,id,password,studentNum,name
    private Integer uno;
    private String id;
    private String password;
    private String studentNum;
    private String name;
    private String role;

    public UserEntity toEntity(){
        UserEntity userEntity= UserEntity.builder()
                .uno(uno)
                .id(id)
                .password(password)
                .studentNum(studentNum)
                .name(name)
                .role(role)
                .build();
        return userEntity;

    }

    @Builder
    public UserDto(Integer uno,String id, String password,String studentNum,String name,String role){
        this.uno=uno;
        this.id=id;
        this.password=password;
        this.studentNum=studentNum;
        this.name=name;
        this.role=role;

    }


}
