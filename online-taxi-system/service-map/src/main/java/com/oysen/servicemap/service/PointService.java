package com.oysen.servicemap.service;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.PointRequest;
import com.oysen.servicemap.remote.PointClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PointService {

    @Autowired
    private PointClient pointClient;

    public ResponseResult upload(PointRequest pointRequest) {
        return pointClient.upload(pointRequest);
    }
}
