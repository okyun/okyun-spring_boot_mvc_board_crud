package com.example.demo.service;


import com.example.demo.service.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClassService {
    private ClassRepository classRepository;
}
