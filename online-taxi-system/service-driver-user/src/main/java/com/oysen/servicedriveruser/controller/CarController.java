package com.oysen.servicedriveruser.controller;

import com.oysen.internalcommon.dto.Car;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicedriveruser.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/car")
    public ResponseResult addCar(@RequestBody Car car) {

        return carService.addCar(car);
    }

    @GetMapping("/car")
    public ResponseResult<Car> getCarById(Long carId) {
        return carService.getCarById(carId);
    }
}
