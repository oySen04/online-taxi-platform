package com.oysen.internalcommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.oysen.internalcommon.dto.TokenResult;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    //盐
    private static final String SIGN = "OySen!@#$%";
    private static final String JWT_KEY_PHONE = "phone";
    //乘客是1，司机是2
    private static final String JWT_KEY_IDENTITY = "identity";

    //token类型
    private static final String JWT_TOKEN_TYPE= "tokenType";

    private static final String JWT_TOKEN_TIME = "tokenTime";

    public static String generatorToken(String passengerPhone,String identity, String tokenType) {
        Map<String,String> map = new HashMap<>();
        map.put(JWT_KEY_PHONE,passengerPhone);
        map.put(JWT_KEY_IDENTITY,identity);
        map.put(JWT_TOKEN_TYPE,tokenType);
        //过期时间
        /*Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date date = calendar.getTime();*/
        map.put(JWT_TOKEN_TIME,Calendar.getInstance().getTime().toString());

        JWTCreator.Builder builder = JWT.create();
        //整合map
        map.forEach(
                (k,v) -> {
            builder.withClaim(k,v);
        });
        //整合过期时间
        //builder.withExpiresAt(date);
        //生成token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));
        return sign;
    }

    //解析token
    public static TokenResult parseToken(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        String phone = verify.getClaim(JWT_KEY_PHONE).asString();
        String identity = verify.getClaim(JWT_KEY_IDENTITY).asString();

        TokenResult tokenResult = new TokenResult();
        tokenResult.setPhone(phone);
        tokenResult.setIdentity(identity);
        return tokenResult;
    }

    /**
     * 校验token，主要判断token是否异常
     * @param token
     * @return
     */
    public static TokenResult checkToken(String token) {
        TokenResult tokenResult = null;
        try {
            tokenResult = JwtUtils.parseToken(token);
       /* }catch (SignatureVerificationException e) {
            resulttString  = "token sing erro";
            result = false;
        }catch (TokenExpiredException e) {
            resulttString = "token time out";
            result = false;
        }catch (AlgorithmMismatchException e) {
            resulttString = "token AlgorithmMismatchException";
            result = false;*/
        }catch (Exception e) {
            /*resulttString = "token incalid";
            result = false;*/
        }
        return tokenResult;
    }

    public static void main(String[] args) {

        String s = generatorToken("17856749098","1","accessToken");
        System.out.println(s);

        System.out.println("解析token后的值:");
        TokenResult tokenResult = parseToken(s);
        System.out.println("手机号:" + tokenResult.getPhone());
        System.out.println("身份:" + tokenResult.getIdentity());
    }
}
