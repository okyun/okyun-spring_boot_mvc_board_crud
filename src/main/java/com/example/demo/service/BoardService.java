package com.example.demo.service;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;

import com.example.demo.domain.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardService {


    @Autowired
    private BoardRepository boardRepository;


    @Transactional
    public void savePost(BoardDto boardDto){
        //boardDto.setName(auth.getName());
        boardRepository.save(boardDto.toEntity());//dto->entity로 비꾸기
    }

    @Transactional
    public BoardDto getPost(Integer bno){//detail post
        Optional<BoardEntity> boardEntityWrapper=boardRepository.findById(bno);
        BoardEntity boardEntity=boardEntityWrapper.get();

        BoardDto boardDto=BoardDto.builder()
                .bno(boardEntity.getBno())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .contentresult(boardEntity.getContentresult())
                .name(boardEntity.getName())
                .grade(boardEntity.getGrade())
                .createdate(boardEntity.getCreatedate())
                .build();

        return boardDto;
    }


    @Transactional
    public List<BoardDto> getBoardlist() {//listAll
        //entity로 받은 리스트를 dto로 옯기기
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .bno(boardEntity.getBno())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .contentresult(boardEntity.getContentresult())
                    .name(boardEntity.getName())
                    .grade(boardEntity.getGrade())
                    .createdate(boardEntity.getCreatedate())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }
    @Transactional
    public void deletePost(Integer bno) {//게시물 삭제
        boardRepository.deleteById(bno);
    }

}
