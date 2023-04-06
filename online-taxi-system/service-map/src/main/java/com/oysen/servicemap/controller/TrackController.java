package com.oysen.servicemap.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicemap.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @PostMapping("/add")
    public ResponseResult add(String tid) {
        return trackService.add(tid);
    }
}
