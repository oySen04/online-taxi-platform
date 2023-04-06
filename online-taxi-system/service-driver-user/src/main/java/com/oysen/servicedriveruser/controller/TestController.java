package com.oysen.servicedriveruser.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicedriveruser.mapper.DriverUserMapper;
import com.oysen.servicedriveruser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DriverUserService driverUserService;

    @GetMapping("/test")
    public String test() {
        return "service-driver-user";
    }

    @GetMapping("/test-db")
    public ResponseResult testDB() {
        return driverUserService.testGetDriverUser();
    }

    @Autowired
    private DriverUserMapper driverUserMapper;
    @GetMapping("/test-xxml")
    public int testXml(String cityCode) {
        int i = driverUserMapper.selectDriverUserCountByCityCode(cityCode);
        return i;
    }
}
