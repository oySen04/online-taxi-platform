package com.oysen.apidriver.service;

import com.oysen.apidriver.remote.ServiceOrderClient;
import com.oysen.internalcommon.constant.IdentityConstants;
import com.oysen.internalcommon.dto.OrderInfo;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ApiDriverOrderInfoService {

    @Autowired
    private ServiceOrderClient serviceOrderClient;

    public ResponseResult toPickUpPassenger(OrderRequest orderRequest) {
        return serviceOrderClient.toPickUpPassenger(orderRequest);
    }

    public ResponseResult arrivedDeparture(OrderRequest orderRequest) {
        return serviceOrderClient.arrivedDeparture(orderRequest);
    }

    //public ResponseResult pickUpPassenger(OrderRequest orderRequest) {
    public ResponseResult pickUpPassenger(@RequestBody OrderRequest orderRequest) {
        return serviceOrderClient.pickUpPassenger(orderRequest);
    }

    public ResponseResult passengerGetoff(OrderRequest orderRequest) {
        return serviceOrderClient.passengerGetoff(orderRequest);
    }

    public ResponseResult cacenl(Long orderId) {
        return serviceOrderClient.cancel(orderId, IdentityConstants.DRIVER_IDENTITY);
    }

    public ResponseResult<OrderInfo> detail(Long orderId) {
        return serviceOrderClient.detail(orderId);
    }

    public ResponseResult<OrderInfo> currentOrder(String phone , String identity) {
        return serviceOrderClient.current(phone,identity);
    }
}
