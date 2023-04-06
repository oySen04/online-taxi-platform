package com.oysen.apidriver.controller;

import com.oysen.apidriver.service.PayService;
import com.oysen.internalcommon.dto.ResponseResult;
import org.apache.catalina.startup.RealmRuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 司机发起收款
     * @param orderId
     * @param price
     * @return
     */
    @PostMapping("/push-pay-info")
    public ResponseResult pushPayInfo(@RequestParam String orderId,@RequestParam String price,@RequestParam Long passengerId) {
        return payService.pushPayInfo(orderId, price, passengerId);
    }
}
