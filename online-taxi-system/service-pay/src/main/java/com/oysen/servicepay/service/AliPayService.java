package com.oysen.servicepay.service;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import com.oysen.servicepay.remote.ServiceOrderClient;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliPayService {

    @Autowired
    private ServiceOrderClient serviceOrderClient;

    public void pay(Long orderId) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pay(orderRequest);
    }
}
