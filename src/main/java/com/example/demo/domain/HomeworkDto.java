package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
@ToString
@Getter
@Setter
public class HomeworkDto {

    private Integer hno;
    private String name;
    private Integer cno;
    private String classname;
    private String dueday;
    private String title;
    private String content;
    private String describe;
    private String lang;

    public HomeworkEntity toEntity(){
        HomeworkEntity homeworkEntity=HomeworkEntity.builder()
                .hno(hno)
                .name(name)
                .cno(cno)
                .classname(classname)
                .dueday(dueday)
                .title(title)
                .content(content)
                .lang(lang)
                .describe(describe)
                .build();
        return homeworkEntity;

    }
    @Builder
    public HomeworkDto(Integer hno,String name,Integer cno,String classname,String dueday,String title,String content,String lang,String describe){
        this.hno=hno;
        this.name=name;
        this.cno=cno;
        this.classname=classname;
        this.dueday=dueday;
        this.title=title;
        this.content=content;
        this.lang=lang;
        this.describe=describe;

    }


}
