package com.example.demo.service.repository;


import com.example.demo.domain.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Integer> {

}
