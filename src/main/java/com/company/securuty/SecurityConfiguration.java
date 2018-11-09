package com.company.securuty;

import com.company.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    UserServiceImpl service;
    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll().and().csrf().disable();
//        http.and().authorizeRequests()
//                .antMatchers("/").hasAnyRole("TEACHER", "STUDENT")
////                .access("hasRole('TEACHER') and hasRole('STUDENT')")
//                .antMatchers("/mark/**").hasRole("TEACHER")
//                .antMatchers("/subject/**").hasRole("TEACHER")
//                .antMatchers("/course/**").hasRole("TEACHER")
//                .antMatchers("/teacher/**").hasRole("TEACHER")
//                .antMatchers("/student/**").hasRole("TEACHER")
//                .antMatchers("/term/**").hasRole("TEACHER")
//                .antMatchers("/group/**").hasRole("TEACHER")
//                .antMatchers("/lesson/").permitAll()
//                .antMatchers("/lesson/find").permitAll()
//                .antMatchers("/lesson/findAll").permitAll()
//                .antMatchers("/lesson/add").hasRole("TEACHER")
//                .antMatchers("/markForLesson/").permitAll()
//                .antMatchers("/markForLesson/find").permitAll()
//                .antMatchers("/markForLesson/findAll").permitAll()
//                .antMatchers("/markForLesson/add").hasRole("TEACHER")
//                .and().formLogin().and().logout().permitAll().and().csrf().disable();
    }

}
