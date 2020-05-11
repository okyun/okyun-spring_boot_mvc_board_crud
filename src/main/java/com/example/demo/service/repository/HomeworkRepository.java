package com.example.demo.service.repository;

import com.example.demo.domain.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity,Integer> {

    List<HomeworkEntity> findByTitle(String title);//제목별로
    List<HomeworkEntity> findByName(String name);//교사별로
    List<HomeworkEntity> findByHno(Integer hno);


}
