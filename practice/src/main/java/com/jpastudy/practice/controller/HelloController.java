package com.jpastudy.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequestMapping("/hello")
    public String hello(){
        return "기본적인 컨트롤러 테스트";
    }
}
