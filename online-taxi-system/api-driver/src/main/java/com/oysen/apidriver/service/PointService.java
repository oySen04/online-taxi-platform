package com.oysen.apidriver.service;

import com.oysen.apidriver.remote.ServiceDriverUserClient;
import com.oysen.apidriver.remote.ServiceMapClient;
import com.oysen.internalcommon.dto.Car;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.ApiDriverPointRequest;
import com.oysen.internalcommon.request.PointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;
    @Autowired
    private ServiceMapClient serviceMapClient;

    public ResponseResult upload(ApiDriverPointRequest apiDriverPointRequest) {
        //获取carID
        Long carId = apiDriverPointRequest.getCarId();

        //通过carID获取tid，trid
        ResponseResult<Car> carById = serviceDriverUserClient.getCarById(carId);
        Car car = carById.getData();
        String tid = car.getTid();
        String trid = car.getTrid();

        //调用地图上传
        PointRequest pointRequest = new PointRequest();
        pointRequest.setTid(tid);
        pointRequest.setTrid(trid);
        pointRequest.setPoints(apiDriverPointRequest.getPoints());

        return serviceMapClient.upload(pointRequest);
    }
}
