package com.example.demo.service;

import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.UserDto;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {


    private UserRepository userRepository;

    @Transactional
    public void saveUser(UserDto userDto){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userDto.toEntity());
    }
    @Transactional
    public UserDto getUser(String id){

        Optional<UserEntity>userEntityWapper=userRepository.findById(id);
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

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<UserEntity>userEntityWapper=userRepository.findById(id);
        UserEntity userEntity=userEntityWapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userEntity.getRole())) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }


        return null;
    }
}
