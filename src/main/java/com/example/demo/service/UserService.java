package com.example.demo.service;

import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.UserDto;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveUser(UserDto userDto){
        userRepository.save(userDto.toEntity());
    }
    @Transactional
    public UserDto getUser(Integer uno){

        Optional<UserEntity>userEntityWapper=userRepository.findById(uno);
        UserEntity userEntity=userEntityWapper.get();

        UserDto userDto=UserDto.builder()
                .uno(userEntity.getUno())
                .id(userEntity.getId())
                .password(userEntity.getPassword())
                .studentNum(userEntity.getStudentNum())
                .name(userEntity.getName())
                .build();

        return userDto;
    }

    @Transactional
    public List<UserDto> getUserList(){
        List<UserEntity> userEntities=userRepository.findAll();
        List<UserDto> userDtoList=new ArrayList<>();

        for (UserEntity userEntity : userEntities){
            UserDto userDto=UserDto.builder()
                    .uno(userEntity.getUno())
                    .id(userEntity.getId())
                    .password(userEntity.getPassword())
                    .studentNum(userEntity.getStudentNum())
                    .name(userEntity.getName())
                    .build();

            userDtoList.add(userDto);
        }

        return userDtoList;

    }
}
