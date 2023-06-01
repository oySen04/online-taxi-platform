package com.oysen.apidriver.service;

import com.oysen.apidriver.remote.ServiceOrderClient;
import com.oysen.apidriver.remote.ServiceSsePushClient;
import com.oysen.internalcommon.constant.IdentityConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import com.oysen.internalcommon.request.PushRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PayService {

    @Autowired
    private ServiceSsePushClient serviceSsePushClient;
    @Autowired
    private ServiceOrderClient serviceOrderClient;

    public ResponseResult pushPayInfo(Long orderId, String price, Long passengerId) {
        //封装消息
        JSONObject message = new JSONObject();
        message.put("price",price);
        message.put("orderId",orderId);
        // 修改订单状态
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pushPayInfo(orderRequest);

        PushRequest pushRequest = new PushRequest();
        pushRequest.setContent(message.toString());
        pushRequest.setUserId(passengerId);
        pushRequest.setIdentity(IdentityConstants.PASSENGER_IDENTITY);
        //推送消息
        serviceSsePushClient.push(pushRequest);
        //serviceSsePushClient.push(passengerId, IdentityConstants.PASSENGER_IDENTITY,message.toString());


        return ResponseResult.success();
    }
}
