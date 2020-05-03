package com.example.demo.service;

import com.example.demo.domain.HomeworkDto;
import com.example.demo.domain.HomeworkEntity;
import com.example.demo.service.repository.HomeworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HomeworkService {

    private HomeworkRepository homeworkRepository;

    @Transactional
    public void saveHomework(HomeworkDto homeworkDto){
        homeworkRepository.save(homeworkDto.toEntity());
    }
    @Transactional
    public List<HomeworkDto> getAllHomeworklist() {//listAll
        //entity로 받은 리스트를 dto로 옯기기
        List<HomeworkEntity> homeworkEntities = homeworkRepository.findAll();
        List<HomeworkDto> homeworkDtoList = new ArrayList<>();

        for ( HomeworkEntity homeworkEntity : homeworkEntities) {
            HomeworkDto homeworkDto = HomeworkDto.builder()
                    .hno(homeworkEntity.getHno())
                    .name(homeworkEntity.getName())
                    .cno(homeworkEntity.getCno())
                    .classname(homeworkEntity.getClassname())
                    .dueday(homeworkEntity.getDueday())
                    .title(homeworkEntity.getTitle())
                    .content(homeworkEntity.getContent())
                    .lang(homeworkEntity.getLang())
                    .build();
            homeworkDtoList.add(homeworkDto);
        }

        return homeworkDtoList;
    }
    @Transactional
    public List<HomeworkDto> getHomeworkListByName(String name){
        List<HomeworkEntity> homeworkEntities = homeworkRepository.findByName(name);
        List<HomeworkDto>homeworkDtoList=new ArrayList<>();


        for(HomeworkEntity homeworkEntity:homeworkEntities){
            HomeworkDto homeworkDto=HomeworkDto.builder()
                    .hno(homeworkEntity.getHno())
                    .name(homeworkEntity.getName())
                    .cno(homeworkEntity.getCno())
                    .classname(homeworkEntity.getClassname())
                    .dueday(homeworkEntity.getDueday())
                    .title(homeworkEntity.getTitle())
                    .content(homeworkEntity.getContent())
                    .lang(homeworkEntity.getLang())
                    .build();
            homeworkDtoList.add(homeworkDto);

        }
        return homeworkDtoList;

    }



}
