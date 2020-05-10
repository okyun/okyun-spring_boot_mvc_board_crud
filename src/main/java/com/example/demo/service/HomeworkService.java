package com.example.demo.service;

import com.example.demo.domain.HomeworkDto;
import com.example.demo.domain.HomeworkEntity;
import com.example.demo.service.repository.HomeworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HomeworkService {

    private HomeworkRepository homeworkRepository;

    @Transactional
    public void saveHomework(HomeworkDto homeworkDto){
        homeworkRepository.save(homeworkDto.toEntity());
    }
    @Transactional
    public HomeworkDto getHomeworkById(Integer hno) {//listAll

        Optional<HomeworkEntity> homeworkWrapper=homeworkRepository.findById(hno);
        HomeworkEntity homeworkEntity=homeworkWrapper.get();

        HomeworkDto homeworkDto=HomeworkDto.builder()
                .hno(homeworkEntity.getHno())

                .name(homeworkEntity.getName())
                .dueday(homeworkEntity.getDueday())
                .title(homeworkEntity.getTitle())
                .des(homeworkEntity.getDes())
                .classname(homeworkEntity.getClassname())
                .lang(homeworkEntity.getLang())


                .build();
        return homeworkDto;

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

                    .classname(homeworkEntity.getClassname())
                    .dueday(homeworkEntity.getDueday())
                    .title(homeworkEntity.getTitle())
                    .content(homeworkEntity.getContent())
                    .des(homeworkEntity.getDes())
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

                    .classname(homeworkEntity.getClassname())
                    .dueday(homeworkEntity.getDueday())
                    .title(homeworkEntity.getTitle())
                    .content(homeworkEntity.getContent())
                    .des(homeworkEntity.getDes())
                    .lang(homeworkEntity.getLang())
                    .build();
            homeworkDtoList.add(homeworkDto);

        }
        return homeworkDtoList;

    }
    @Transactional
    public void deleteHomework(Integer hno) {//게시물 삭제
        homeworkRepository.deleteById(hno);
    }



}
