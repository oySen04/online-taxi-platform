package com.oysen.servicemap.service;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.DirectionResponse;
import com.oysen.servicemap.remote.MapDirectionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionService {

    @Autowired
    private MapDirectionClient mapDirectionClient;


    /**
     * 根据起点经纬度和目的地经纬度获取距离（米）和时长（分钟）
     * @param depLongitude
     * @param depLatitude
     * @param desLongitude
     * @param desLatitude
     * @return
     */
    public ResponseResult driving(String depLongitude,String depLatitude,String desLongitude,String desLatitude) {

        //调用第三方接口
        DirectionResponse direction = mapDirectionClient.direction(depLongitude, depLatitude, desLongitude, desLatitude);


        return ResponseResult.success(direction);
    }
}
