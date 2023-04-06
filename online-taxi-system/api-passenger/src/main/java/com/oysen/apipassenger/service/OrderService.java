package com.oysen.apipassenger.service;


import com.oysen.apipassenger.remote.ServiceOrderClient;
import com.oysen.internalcommon.constant.IdentityConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ServiceOrderClient serviceOrderClient;

    public ResponseResult add(OrderRequest orderRequest) {
        return serviceOrderClient.add(orderRequest);
    }

    /**
     * 乘客取消订单
     * @param orderId
     * @return
     */
    public ResponseResult cancel(Long orderId) {
        return serviceOrderClient.cancel(orderId, IdentityConstants.PASSENGER_IDENTITY);
    }
}
