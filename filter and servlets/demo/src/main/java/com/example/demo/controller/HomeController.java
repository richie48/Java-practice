package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HomeController {
    private Map<String,Object> result =new HashMap<>();

    @RequestMapping("/hello")
    public Map<String,Object> hello(){

        result.put("name","stephen");
        result.put("city","san jose");
        return result;
    }
}
