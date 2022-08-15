package com.jaymoswaggerapp.services;


import com.jaymoswaggerapp.entity.User;
import com.jaymoswaggerapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class UserService  {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User getUserByUserNameAndPassword(String userName , String password){
        return userRepository.getUserByUserNameAndPassword(userName, password);
    }

    public User getUserByUserName(String username){
        return userRepository.getUserByUserName(username);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        log.info("About to loadUserByUsername by {} ", username);
//        //TODO
//        User userDetails = getUserByUserName(username);
//        log.info("Fetched user details {} ", userDetails);
//        if(userDetails == null){
//            throw new UsernameNotFoundException("User not found ");
//        }
//        return new org.springframework.security.core.userdetails.User(userDetails.getUserName(), userDetails.getPassword(), new ArrayList<>());
//    }
}
