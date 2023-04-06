package com.oysen.servicemap.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicemap.service.ServiceFromMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 服务管理控制器
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceFromMapService serviceFromMapService;

    /**
     * 创建服务 猎鹰服务
     * @param name
     * @return
     */
    @PostMapping("/add")
    public ResponseResult add(String name) {
        return serviceFromMapService.add(name);
    }
}
