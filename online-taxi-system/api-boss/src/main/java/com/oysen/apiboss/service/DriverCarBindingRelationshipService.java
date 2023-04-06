package com.oysen.apiboss.service;

import com.oysen.apiboss.remote.ServiceDriverUserClient;
import com.oysen.internalcommon.constant.CommonStatusEnum;
import com.oysen.internalcommon.constant.DriverCarConstants;
import com.oysen.internalcommon.dto.DriverCarBindingRelationship;
import com.oysen.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yang
 * @since 2023-08-11
 */
@Service
public class DriverCarBindingRelationshipService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship) {
        return serviceDriverUserClient.bind(driverCarBindingRelationship);

    }

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship) {

        return serviceDriverUserClient.unbind(driverCarBindingRelationship);
    }
}
