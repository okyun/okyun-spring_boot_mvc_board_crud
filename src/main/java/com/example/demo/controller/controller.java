package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
}