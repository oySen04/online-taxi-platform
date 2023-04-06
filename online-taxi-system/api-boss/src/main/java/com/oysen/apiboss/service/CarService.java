package com.oysen.apiboss.service;

import com.oysen.apiboss.remote.ServiceDriverUserClient;
import com.oysen.internalcommon.dto.Car;
import com.oysen.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addCar(Car car) {

        return serviceDriverUserClient.addCar(car);
    }
}
