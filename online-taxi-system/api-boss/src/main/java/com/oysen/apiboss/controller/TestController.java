package com.oysen.apiboss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 测试接口
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "api-boss";
    }
}
