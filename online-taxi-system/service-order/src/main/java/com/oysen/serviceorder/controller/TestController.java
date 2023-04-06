package com.oysen.serviceorder.controller;

import com.oysen.internalcommon.dto.OrderInfo;
import com.oysen.serviceorder.mapper.OrderInfoMapper;
import com.oysen.serviceorder.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "service-order";
    }

    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Value("${server.port}")
    String port;

    @GetMapping("/test-real-time-order/{orderId}")
    public String dispatchRealTimeOrder(@PathVariable("orderId") Long orderId) {

        System.out.println("端口:" + port + "测试" + orderId);
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);
        orderInfoService.dispatchRealTimeOrder(orderInfo);

        return "test-test-real-time-order success";
    }
}
