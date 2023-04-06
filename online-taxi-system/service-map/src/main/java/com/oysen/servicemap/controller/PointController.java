package com.oysen.servicemap.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.PointRequest;
import com.oysen.servicemap.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody PointRequest pointRequest) {
        return pointService.upload(pointRequest);
    }
}
