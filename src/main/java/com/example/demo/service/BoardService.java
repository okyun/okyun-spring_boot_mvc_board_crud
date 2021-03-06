package com.example.demo.service;

import com.example.demo.domain.BoardDto;
import com.example.demo.domain.BoardEntity;



import com.example.demo.service.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

                .hno(boardEntity.getHno())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .contentresult(boardEntity.getContentresult())
                .classname(boardEntity.getClassname())
                .name(boardEntity.getName())
                .grade(boardEntity.getGrade())
                .createdate(boardEntity.getCreatedate())
                .lang(boardEntity.getLang())
                .teacher(boardEntity.getTeacher())
                .dueday(boardEntity.getDueday())
                .studentnum(boardEntity.getStudentnum())
                .build();

        return boardDto;
    }


    @Transactional
    public List<BoardDto> getAllBoardlist() {//listAll
        //entity로 받은 리스트를 dto로 옯기기
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .bno(boardEntity.getBno())
                    .classname(boardEntity.getClassname())
                    .hno(boardEntity.getHno())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .contentresult(boardEntity.getContentresult())
                    .name(boardEntity.getName())
                    .grade(boardEntity.getGrade())
                    .createdate(boardEntity.getCreatedate())
                    .lang(boardEntity.getLang())
                    .teacher(boardEntity.getTeacher())
                    .dueday(boardEntity.getDueday())
                    .studentnum(boardEntity.getStudentnum())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }

    @Transactional
    public List<BoardDto> getBoardListByName(String name){
        List<BoardEntity> boardEntities = boardRepository.findByName(name);
        List<BoardDto>boardDtoList=new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .bno(boardEntity.getBno())
                    .classname(boardEntity.getClassname())
                    .hno(boardEntity.getHno())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .contentresult(boardEntity.getContentresult())
                    .name(boardEntity.getName())
                    .grade(boardEntity.getGrade())
                    .createdate(boardEntity.getCreatedate())
                    .lang(boardEntity.getLang())
                    .teacher(boardEntity.getTeacher())
                    .dueday(boardEntity.getDueday())
                    .studentnum(boardEntity.getStudentnum())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }

    @Transactional
    public List<BoardDto> getBoardListByHno(Integer hno){
        List<BoardEntity> boardEntities = boardRepository.findByHno(hno);
        List<BoardDto>boardDtoList=new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .bno(boardEntity.getBno())
                    .classname(boardEntity.getClassname())
                    .hno(boardEntity.getHno())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .contentresult(boardEntity.getContentresult())
                    .name(boardEntity.getName())
                    .grade(boardEntity.getGrade())
                    .createdate(boardEntity.getCreatedate())
                    .lang(boardEntity.getLang())
                    .teacher(boardEntity.getTeacher())
                    .dueday(boardEntity.getDueday())
                    .studentnum(boardEntity.getStudentnum())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }


    @Transactional
    public void deletePost(Integer bno) {//게시물 삭제
        boardRepository.deleteById(bno);
    }
    @Transactional
    public void deletePostList(Integer hno) {//게시물 삭제2
        boardRepository.deleteAllByHno(hno);
    }


}
