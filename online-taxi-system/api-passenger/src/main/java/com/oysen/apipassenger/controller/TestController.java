package com.oysen.apipassenger.controller;

import com.oysen.apipassenger.remote.ServiceOrderClient;
import com.oysen.internalcommon.dto.OrderInfo;
import com.oysen.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 需要token
     * @return
     */
    @GetMapping("/authTest")
    public ResponseResult authTest() {
        return ResponseResult.success("authTest");
    }

    /***
     * 不需要token
     * @return
     */
    @GetMapping("/noauthTest")
    public ResponseResult noauthTest() {
        return ResponseResult.success("noauthTest");
    }

    @Autowired
    private ServiceOrderClient serviceOrderClient;


    /**
     * 并发压力测试
     * @param orderId
     * @return
     */
    public String dispatchRealTimeOrder(@PathVariable("orderId") Long orderId) {

        System.out.println("并发压力测试" + orderId);
        serviceOrderClient.dispatchRealTimeOrder(orderId);

        return "test-test-real-time-order success";
    }
}
