package com.oysen.apipassenger.controller;

import com.oysen.apipassenger.service.OrderService;
import com.oysen.internalcommon.constant.IdentityConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody OrderRequest orderRequest) {
        System.out.println(orderRequest);
        return orderService.add(orderRequest);
    }

    /**
     * 乘客取消订单
     * @param orderId
     * @return
     */
    public ResponseResult cacel(@RequestParam Long orderId) {
        return orderService.cancel(orderId);
    }
}
