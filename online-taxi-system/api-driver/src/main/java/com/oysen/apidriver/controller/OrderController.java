package com.oysen.apidriver.controller;

import com.oysen.apidriver.service.ApiDriverOrderInfoService;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ApiDriverOrderInfoService apiDriverOrderInfoService;
    /**
     * 去接乘客
     * @param orderRequest
     * @return
     */
    @PostMapping("/to-pick-up-passenger")
    public ResponseResult changeStatus(@RequestBody OrderRequest orderRequest) {
        return apiDriverOrderInfoService.toPickUpPassenger(orderRequest);
    }

    /**
     * 到达乘客上车地点
     * @param orderRequest
     * @return
     */
    @PostMapping("/arrived-departure")
    public ResponseResult arrivedDeparture(@RequestBody OrderRequest orderRequest) {
        return apiDriverOrderInfoService.arrivedDeparture(orderRequest);
    }

    /**
     * 司机接到乘客
     * @param orderRequest
     * @return
     */
    @PostMapping("/pick-up-passenger")
    public ResponseResult pickUpPassenger(@RequestBody OrderRequest orderRequest) {
        return apiDriverOrderInfoService.pickUpPassenger(orderRequest);
    }

    /**
     * 乘客到达目的地,行程终止
     * @param orderRequest
     * @return
     */
    @PostMapping("/passenger-getoff")
    public ResponseResult passengerGetoff(@RequestBody OrderRequest orderRequest) {
        return apiDriverOrderInfoService.passengerGetoff(orderRequest);
    }

    @PostMapping("/cancel")
    public ResponseResult cacenl(@RequestParam Long orderId) {
        return apiDriverOrderInfoService.cacenl(orderId);
    }
}
