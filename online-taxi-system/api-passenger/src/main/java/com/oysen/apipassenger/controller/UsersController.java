package com.oysen.apipassenger.controller;

import com.oysen.apipassenger.service.UsersService;
import com.oysen.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseResult getUsers(HttpServletRequest request) {
        //从http请求中获取accessToken
        String accessToken = request.getHeader("Authorization");

        return usersService.getUsersByAccessToken(accessToken);
    }
}
