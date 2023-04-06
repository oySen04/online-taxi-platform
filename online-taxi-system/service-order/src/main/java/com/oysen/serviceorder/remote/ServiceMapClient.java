package com.oysen.serviceorder.remote;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.TerminalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.POST,value = "/terminal/aroundsearch")
    public ResponseResult<List<TerminalResponse>> terminalAroundSearch(@RequestParam String center, @RequestParam Integer radius);

    @RequestMapping(method = RequestMethod.POST,value = "/terminal/trsearch")
    public ResponseResult<TerminalResponse> trsearch(@RequestParam String tid,@RequestParam Long starttime,@RequestParam Long endtime);
}
