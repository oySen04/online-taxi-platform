package com.oysen.apidriver.remote;

import com.oysen.internalcommon.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-sse-push")
public interface ServiceSsePushClient {

    @RequestMapping(method = RequestMethod.GET,value = "/push")
    public ResponseResult push(@RequestParam Long orderId, @RequestParam String price, @RequestParam String passengerId);
}
