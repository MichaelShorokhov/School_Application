package com.company.service;

import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService{
    @Autowired
    UserRepository repository;

//    private com.company.entities.UserDetails user;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.company.entities.UserDetails user = repository.findById(s).get();
        System.out.println(user.getLogin() + user.getPassword() + user.getAuth());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getAuth().toUpperCase()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),true,true,true,true, authorities);
    }

//    public com.company.entities.UserDetails findUserByName(String name) {
//        this.user = repository.findById(name).get();
//        System.out.println(user.getLogin() + user.getPassword() + user.getAuth());
//        return this.user;
//    }
//
//    public boolean isUserValid(String pass){
//        return pass.equals(user.getPassword());
//    }


}
