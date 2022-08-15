package com.jaymoswaggerapp.controllers;


import com.jaymoswaggerapp.config.StatusCodes;
import com.jaymoswaggerapp.dto.ResponseDTO;
import com.jaymoswaggerapp.entity.User;
import com.jaymoswaggerapp.repository.UserRepository;
import com.jaymoswaggerapp.services.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController(value = "/test")
@Slf4j
public class TestController {

//    @Autowired
//    private JwtUtil jwtUtil;

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;


    @GetMapping("test")
    public String test() throws Exception{
        User myUser = userService.getUserByUserNameAndPassword("jim","1234");
        log.info("Fetched user details {} ",myUser);
        return "Hello";
    }

    @ApiOperation(value = "This method is used to get the clients.")
    @GetMapping("/getClients")
    public List<String> getClients() {
        return Arrays.asList("First Client", "Second Client");
    }

    @GetMapping("save-user")
    public ResponseDTO<?> saveUser(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) String password
    ) throws Exception{

        if(userRepository.existsByUserName(username)){
            return new ResponseDTO<>(
                    StatusCodes.FAILED,
                    "Already exists"
            );
        }

        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Saved",
                Arrays.asList(userRepository.save(User.builder().userName(username).password(encoder.encode(password)).build()))
        );
    }


//    @GetMapping("get-token")
//    public ResponseDTO<?> getToken(
//            @RequestParam(required = true) String username,
//            @RequestParam(required = true) String password
//    ) throws Exception{
//
//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//
//        var token = jwtUtil.generateToken(username);
//        if(token != null){
//            return new ResponseDTO<>(
//                    StatusCodes.SUCCESS,
//                    "Token generated",
//                    Arrays.asList(token));
//        }
//
//        return new ResponseDTO<>(
//                StatusCodes.FAILED,
//                "Failed");
//    }


}
