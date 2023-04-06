package com.oysen.apidriver.service;

import com.oysen.apidriver.remote.ServiceSsePushClient;
import com.oysen.internalcommon.constant.IdentityConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PayService {

    @Autowired
    private ServiceSsePushClient serviceSsePushClient;

    public ResponseResult pushPayInfo(String orderId, String price, Long passengerId) {
        //封装消息
        JSONObject message = new JSONObject();
        message.put("price",price);
        message.put("orderId",orderId);

        serviceSsePushClient.push(passengerId, IdentityConstants.PASSENGER_IDENTITY,message.toString());
        //推送消息

        return ResponseResult.success();
    }
}
