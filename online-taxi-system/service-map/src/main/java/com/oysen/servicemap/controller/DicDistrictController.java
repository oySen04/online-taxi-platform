package com.oysen.servicemap.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicemap.remote.MapDicDistrictClient;
import com.oysen.servicemap.service.DicDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DicDistrictController {

    @Autowired
    private DicDistrictService dicDistrictService;

    @GetMapping("/dic-district")
    public ResponseResult iniDistrict(String keywords) {

        return dicDistrictService.iniDistrict(keywords);
    }
}
