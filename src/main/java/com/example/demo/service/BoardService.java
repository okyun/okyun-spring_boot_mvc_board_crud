package com.example.demo.service;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {


    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void savePost(BoardDto boardDto){


        boardRepository.save(boardDto.toEntity());//dto->entity로 비꾸기
    }


    @Transactional
    public List<BoardDto> getBoardlist() {//entity로 받은 리스트를 dto로 옯기기
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .bno(boardEntity.getBno())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    //.createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }


}
