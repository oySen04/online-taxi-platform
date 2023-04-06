package com.oysen.apidriver.controller;

import com.oysen.apidriver.service.VerificationCodeService;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.VerificationCodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {

        String driverPhone = verificationCodeDTO.getDriverPhone();
        System.out.println(driverPhone);
        return verificationCodeService.checkAndsendVerificationCode(driverPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {

        String driverPhone = verificationCodeDTO.getDriverPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();

        System.out.println(driverPhone +":"+ verificationCode);
        return verificationCodeService.checkCode(driverPhone,verificationCode);
    }
}
