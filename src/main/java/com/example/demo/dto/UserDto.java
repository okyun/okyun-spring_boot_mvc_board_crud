package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {

    private String id;
    private String password;
    private String idNum;//학번
    private Boolean is_student;
    private Boolean is_teacher;

}
