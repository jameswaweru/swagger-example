package com.jaymoswaggerapp.controllers;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Test Controller", description = "shows hello world")
public class TestApi {

    public static final String TEST_CONTROLLER = "/test";


    @GetMapping(value = TEST_CONTROLLER) //produces = MediaType.APPLICATION_JSON_VALUE
    public String test(){
        return "Hello welcome here";
    }


}
