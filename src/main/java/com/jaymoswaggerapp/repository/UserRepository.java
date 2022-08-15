package com.jaymoswaggerapp.repository;


import com.jaymoswaggerapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUserNameAndPassword(String username, String password);

    User getUserByUserName(String username);

    Boolean existsByUserName(String username);

}
