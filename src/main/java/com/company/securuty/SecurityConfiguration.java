package com.company.securuty;

import com.company.controller.CORSFilter;
import com.company.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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
        http.httpBasic().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "login/**").permitAll()
                .antMatchers("/mark").hasRole("TEACHER")
                .antMatchers("/subject").hasRole("TEACHER")
                .antMatchers("/course").hasRole("TEACHER")
                .antMatchers("/teacher").hasRole("TEACHER")
                .antMatchers("/student").hasRole("TEACHER")
                .antMatchers("/term").hasRole("TEACHER")
                .antMatchers("/group").hasRole("TEACHER")
//                .anyRequest().authenticated()
        ;

    }

}
