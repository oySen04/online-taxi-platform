package com.oysen.apipassenger.remote;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("service-order")
public interface ServiceOrderClient {

    @RequestMapping(method = RequestMethod.POST,value = "/order/add")
    public ResponseResult add(@RequestBody OrderRequest orderRequest);

    /**
     * 并发压力测试
     * @param orderId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/test-real-time-order/{orderId}")
    public String dispatchRealTimeOrder(@PathVariable("orderId") Long orderId);

    @RequestMapping(method = RequestMethod.POST,value = "/oeder/cancel")
    public ResponseResult cancel(@RequestParam Long orderId, @RequestParam String identity);
}
