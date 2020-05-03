package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ClassDto {
    private Integer cno;
    private String classname;

    public ClassEntity toEntity(){
        ClassEntity classEntity=ClassEntity.builder()
                .cno(cno)
                .classname(classname)
                .build();
        return classEntity;
    }
    @Builder
    public ClassDto(Integer cno,String classname){
        this.cno=cno;
        this.classname=classname;
    }

}
