package com.example.demo.service;

import com.example.demo.domain.BoardEntity;
import com.example.demo.domain.Role;
import com.example.demo.domain.UserDto;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Transactional
    public void saveUser(UserDto userDto){
         //userRepository.save(userDto.toEntity());
        log.info("아 여기는 회원가입saveUser!!!!!!!!!!");
    
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userDto.toEntity());

        log.info("00000000000000"+userDto.toString());
    }

    @Transactional
    public UserDto getUser(String username){

        Optional<UserEntity>userEntityWapper=userRepository.findByUsername(username);
        UserEntity userEntity=userEntityWapper.get();

        UserDto userDto=UserDto.builder()
                .username(userEntity.getUsername())//2
                .password(userEntity.getPassword())//3
                .studentnum(userEntity.getStudentnum())//4
                .name(userEntity.getName())//5
                .authority(userEntity.getAuthority())//6
                .build();

        return userDto;
    }

    @Transactional
    public List<UserDto> getUserList(){
        List<UserEntity> userEntities=userRepository.findAll();
        List<UserDto> userDtoList=new ArrayList<>();

        for (UserEntity userEntity : userEntities){
            UserDto userDto=UserDto.builder()
                    .username(userEntity.getUsername())//2
                    .password(userEntity.getPassword())//3
                    .studentnum(userEntity.getStudentnum())//4
                    .name(userEntity.getName())//5
                    .authority(userEntity.getAuthority())//6
                    .build();

            userDtoList.add(userDto);
        }

        return userDtoList;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity>userEntityWapper=userRepository.findByUsername(username);
        UserEntity userEntity=userEntityWapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        log.info("44444444444444loadUserByUsername");

        if (("ROLE_USER").equals(userEntity.getAuthority())) {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
            log.info("5555555555555555555555getrole-USER");
        }
        if (("ROLE_MEMBER").equals(userEntity.getAuthority())) {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
            log.info("5555555555555555555555getrole-MEMBER");
        }
        if (("ROLE_ADMIN").equals(userEntity.getAuthority())) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
            log.info("5555555555555555555555getrole-ADMIN");
        } if (("ROLE_STUDENT").equals(userEntity.getAuthority())) {
            authorities.add(new SimpleGrantedAuthority(Role.STUDENT.getValue()));
            log.info("5555555555555555555555getrole-STUDENT");
        }
        if (("ROLE_TEACHER").equals(userEntity.getAuthority())) {
            authorities.add(new SimpleGrantedAuthority(Role.TEACHER.getValue()));
            log.info("5555555555555555555555getrole-TEACHER");
        }
         User user=new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
         UserDto userDto=new UserDto(userEntity.getUsername(),userEntity.getPassword(),userEntity.getStudentnum(),userEntity.getName(),userEntity.getAuthority());
        log.info("66666666666666666666666666666666userEntity.getAuthority()"+ userEntity.getAuthority());


        return userDto;

    }
}
