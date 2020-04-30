package com.example.demo.domain.repository;

import com.example.demo.domain.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity,Integer> {
}
