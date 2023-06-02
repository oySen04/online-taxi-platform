package com.oysen.apidriver.service;

import com.oysen.apidriver.remote.ServiceDriverUserClient;
import com.oysen.apidriver.remote.ServiceVerificationCodeClient;
import com.oysen.internalcommon.constant.CommonStatusEnum;
import com.oysen.internalcommon.constant.DriverCarConstants;
import com.oysen.internalcommon.constant.IdentityConstants;
import com.oysen.internalcommon.constant.TokenConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.VerificationCodeDTO;
import com.oysen.internalcommon.responese.DriverUserExistsResponse;
import com.oysen.internalcommon.responese.NumberCodeResponse;
import com.oysen.internalcommon.responese.TokenResponse;
import com.oysen.internalcommon.util.JwtUtils;
import com.oysen.internalcommon.util.RedisPrefixUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VerificationCodeService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;
    @Autowired
    private ServiceVerificationCodeClient serviceVerificationCodeClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult checkAndsendVerificationCode(String driverPhone) {
        //查询该手机号的司机是否存在
        ResponseResult<DriverUserExistsResponse> driverUserExistsResponseResponseResult = serviceDriverUserClient.checkDrive(driverPhone);
        DriverUserExistsResponse data = driverUserExistsResponseResponseResult.getData();
        int ifExists = data.getIfExists();
        if (ifExists != DriverCarConstants.DRIVER_EXISTS) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXISTS.getCode(),CommonStatusEnum.DRIVER_NOT_EXISTS.getValue());
        }
        log.info(driverPhone + "的司机存在");
        //获取验证码
        ResponseResult<NumberCodeResponse> verificationCodeResult = serviceVerificationCodeClient.getNumberCode(6);
        NumberCodeResponse numberCodeResponse = verificationCodeResult.getData();
        int numberCode = numberCodeResponse.getNumberCode();
        log.info("验证码:" + numberCode);
        //调用第三方发送验证码
        //插入redis
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone, IdentityConstants.DRIVER_IDENTITY);
        stringRedisTemplate.opsForValue().set(key,numberCode + "",2,TimeUnit.MINUTES);
        return ResponseResult.success("");
    }

    /**
     * 校验验证码
     * @param driverPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
    public ResponseResult checkCode(String driverPhone,String verificationCode) {

        //根据手机号读取验证码
        System.out.println("根据手机号读取验证码");
        //生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone,IdentityConstants.DRIVER_IDENTITY);
        //根据key获取value
        String codeRides = stringRedisTemplate.opsForValue().get(key);
        System.out.println(codeRides);
        //校验验证码
        System.out.println("校验验证码");
        if (StringUtils.isBlank(codeRides)) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if (!verificationCode.trim().equals(codeRides.trim())) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
       /* //判断用户是否存在，并进行处理
        System.out.println("判断用户是否存在，并进行处理");
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setDriverPhone(driverPhone);
        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);*/
        //颁发令牌
        String accessToken = JwtUtils.generatorToken(driverPhone, IdentityConstants.DRIVER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(driverPhone, IdentityConstants.DRIVER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);
        //将token存入redis
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone, IdentityConstants.DRIVER_IDENTITY,TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey, accessToken ,30,TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone, IdentityConstants.DRIVER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey, refreshToken ,31,TimeUnit.DAYS);
        //响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }
}
