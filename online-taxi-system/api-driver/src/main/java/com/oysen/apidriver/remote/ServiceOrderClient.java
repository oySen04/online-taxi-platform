package com.oysen.apidriver.remote;

import com.fasterxml.jackson.databind.node.POJONode;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-order")
public interface ServiceOrderClient {

    @RequestMapping(method = RequestMethod.POST,value = "/order/to-pick-up-passenger")
    public ResponseResult toPickUpPassenger(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST,value = "/order/arrived-departure")
    public ResponseResult arrivedDeparture(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST,value = "/order/pick-up-passenger")
    public ResponseResult pickUpPassenger(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST,value = "/order/passenger-getoff")
    public ResponseResult passengerGetoff(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST,value = "/oeder/cancel")
    public ResponseResult cancel(@RequestParam Long orderId, @RequestParam String identity);
}
