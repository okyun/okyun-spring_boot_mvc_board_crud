package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDto {

    private int num;
    private String title;
    private String content;
    private String writer;
    private String password;
    private Date wirteDate;


}
