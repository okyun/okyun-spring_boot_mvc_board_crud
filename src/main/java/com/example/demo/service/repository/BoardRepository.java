package com.example.demo.service.repository;


import com.example.demo.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {
  List<BoardEntity> findByName(String name);//마이페이지 에서

  List<BoardEntity> findByHno(Integer hno);//hno로 구별하기
  List<BoardEntity> deleteAllByHno(Integer hno);

}
