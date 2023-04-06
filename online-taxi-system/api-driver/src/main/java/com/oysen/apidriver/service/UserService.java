package com.oysen.apidriver.service;

import com.oysen.apidriver.remote.ServiceDriverUserClient;
import com.oysen.internalcommon.dto.DriverCarBindingRelationship;
import com.oysen.internalcommon.dto.DriverUser;
import com.oysen.internalcommon.dto.DriverUserWorkStatus;
import com.oysen.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult updateUser(DriverUser driverUser) {
        return serviceDriverUserClient.updateUser(driverUser);
    }

    public ResponseResult changeWorkStatus(DriverUserWorkStatus driverUserWorkStatus) {
        return serviceDriverUserClient.changeWorkStatus(driverUserWorkStatus);
    }

    public ResponseResult<DriverCarBindingRelationship> getDriverCarBindingRelationship(String driverPhone) {

        return serviceDriverUserClient.getDriverCarBindingRelationship(driverPhone);
    }
}
