package com.oysen.servicepassengeruser.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.VerificationCodeDTO;
import com.oysen.servicepassengeruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
     private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO) {

        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println(passengerPhone);
        return userService.loginOrRegister(passengerPhone);
    }

    @GetMapping("/user/{phone}")
    public ResponseResult getUser(@PathVariable("phone") String passengerPhone) {
        System.out.println("service-passenger-user: " + passengerPhone);
        return userService.getUserByPhone(passengerPhone);
    }
}
