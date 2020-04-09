package com.example.demo.service;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {


    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void savePost(BoardDto boardDto){


       boardRepository.save(boardDto.toEntity());//dto->entity로 비꾸기
    }




}
