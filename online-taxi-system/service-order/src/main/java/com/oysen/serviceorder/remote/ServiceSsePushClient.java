package com.oysen.serviceorder.remote;

import com.oysen.internalcommon.request.PushRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@FeignClient("service-sse-push")
public interface ServiceSsePushClient {

    @RequestMapping(method = RequestMethod.GET,value = "/push")
    //public String push(@RequestParam Long userId, @RequestParam String identity,@RequestParam String content);
    public String push(@RequestBody PushRequest pushRequest);
}
