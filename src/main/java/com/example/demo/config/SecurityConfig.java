package com.example.demo.config;


import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/assets/**", "/css/**", "/font/**", "/images/**", "/js/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 페이지 권한 설정
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/listAll").hasRole("STUDENT")
                .antMatchers("/TEACHER/**").hasRole("TEACHER")
                .antMatchers("/STUDENT/**").hasRole("STUDENT")
                .antMatchers("/**").permitAll()
                .and() // 로그인 설정
                .formLogin()
                .loginPage("/user/login")
                .permitAll()
                .and() // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                // 403 예외처리 핸들링
                .exceptionHandling().accessDeniedPage("/user/denied")
                .and()
                .csrf().disable();


    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication().withUser("woolbro").password("{noop}woolbro").roles("USER","ADMIN","MEMBER","TEACHER","STUDENT");
//        auth.inMemoryAuthentication().withUser("woolbro1").password("{noop}woolbro1").roles("USER","MEMBER");
//        auth.inMemoryAuthentication().withUser("student").password("{noop}student").roles("STUDENT");
//        auth.inMemoryAuthentication().withUser("teacher").password("{noop}teacher").roles("TEACHER");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

    }

}
