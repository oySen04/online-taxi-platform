package com.oysen.servicedriveruser.remote;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.TerminalResponse;
import com.oysen.internalcommon.responese.TrackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.POST,value = "/terminal/add")
    public ResponseResult<TerminalResponse> addTerminal(@RequestParam String name,@RequestParam String desc);

    @RequestMapping(method = RequestMethod.POST,value = "/track/add")
    public ResponseResult<TrackResponse> addTrack(@RequestParam String tid);

}
