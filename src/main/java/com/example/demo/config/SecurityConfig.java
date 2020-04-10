package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/guest/**").permitAll()
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/admin/**").hasRole("ADMIN")


                .and()

                .formLogin() /* 로그인 폼 나오도록 */
                .loginPage("/login") /* 내가 만든 로그인 페이지 */
                .usernameParameter("email") /* username 을 대체할 아이디 param default username */
                .passwordParameter("password") /* password 를 대체할 패스워드 param default password */
                .defaultSuccessUrl("/")
                .permitAll() /* 모두 오픈 ( 반대는 denyAll() ) */
                .and()
                .logout().permitAll().logoutSuccessUrl("/")
                .and()
                .csrf().disable(); /* 로그아웃 성공시 리다이렉트 url */




        /*http.formLogin();
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);*/


    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //log.info("build Auth global.......");

        auth.inMemoryAuthentication()
                .withUser("manager")
                .password("{noop}1111")
                .roles("MANAGER");
    }

}
