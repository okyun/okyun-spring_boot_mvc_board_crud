package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  Role {
    USER("ROLE_USER"),
    MEMBER("ROLE_MEMBER"),
    ADMIN("ROLE_ADMIN"),
    STUDENT("ROLE_STUDENT"),//학생
    TEACHER("ROLE_TEACHER");//교수
    private String value;
}
