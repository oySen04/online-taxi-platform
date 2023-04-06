package com.oysen.servicemap.service;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicemap.remote.TrackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

    @Autowired
    private TrackClient trackClient;

    public ResponseResult add(String tid) {
        return trackClient.add(tid);
    }
}
