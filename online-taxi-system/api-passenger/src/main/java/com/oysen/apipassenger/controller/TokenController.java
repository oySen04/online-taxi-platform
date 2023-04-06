package com.oysen.apipassenger.controller;

import com.oysen.apipassenger.service.TokenService;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse) {

        String refreshTokenSrc = tokenResponse.getRefreshToken();
        System.out.println("原先的refreshToken" + refreshTokenSrc);

        return tokenService.refreshToken(refreshTokenSrc);
    }
}
