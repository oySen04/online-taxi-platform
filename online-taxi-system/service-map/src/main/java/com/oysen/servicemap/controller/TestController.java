package com.oysen.servicemap.controller;

import com.oysen.internalcommon.dto.DicDistrict;
import com.oysen.servicemap.mapper.DicDistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "service-map";
    }

    @Autowired
    DicDistrictMapper mapper;

    @GetMapping("/test-map")
    public String testMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("address_code","110000");
        List<DicDistrict> dicDistricts = mapper.selectByMap(map);
        System.out.println(dicDistricts);
        return "testMap";
    }
}
