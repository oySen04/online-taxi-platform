package com.oysen.servicemap.service;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicemap.remote.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFromMapService {

    @Autowired
    private ServiceClient serviceClient;


    /**
     * 创建服务
     * @param name
     * @return
     */
    public ResponseResult add(String name) {
        return serviceClient.add(name);
    }
}
