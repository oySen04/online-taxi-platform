package com.oysen.servicedriveruser.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicedriveruser.service.CityDriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city-driver")
public class CityDriverController {

    @Autowired
    private CityDriverUserService cityDriverUserService;

    /**
     * 根据城市码查询当前城市是否有可用司机
     * @param cityCode
     * @return
     */
    @GetMapping("/is-alailable-driver")
    public ResponseResult isAvailableDriver(String cityCode) {
        return cityDriverUserService.isAvailableDriver(cityCode);
    }
}
