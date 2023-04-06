package com.oysen.apipassenger.service;

import com.oysen.apipassenger.remote.ServicePassengerUserClient;
import com.oysen.internalcommon.dto.PassengerUser;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.dto.TokenResult;
import com.oysen.internalcommon.request.VerificationCodeDTO;
import com.oysen.internalcommon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsersService {

    @Autowired
    ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult getUsersByAccessToken(String accessToken) {
        log.info("accessToken:" + accessToken);
        //解析accessToken获取手机号
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("手机号:" + phone);

        //根据手机号查询用户信息
        /*VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(phone);*/
        ResponseResult<PassengerUser> userByPhone = servicePassengerUserClient.getUserByPhone(phone);

        return ResponseResult.success(userByPhone.getData());
    }
}
