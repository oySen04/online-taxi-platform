package com.oysen.servicedriveruser.controller;

import com.oysen.internalcommon.constant.DriverCarConstants;
import com.oysen.internalcommon.dto.DriverCarBindingRelationship;
import com.oysen.internalcommon.dto.DriverUser;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.DriverUserExistsResponse;
import com.oysen.internalcommon.responese.OrderDriverResponse;
import com.oysen.servicedriveruser.service.DriverCarBindingRelationshipService;
import com.oysen.servicedriveruser.service.DriverUserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private DriverUserService driverUserService;
    @Autowired
    private DriverCarBindingRelationshipService driverCarBindingRelationshipService;

    /**
     * 新增司机
     * @param driverUser
     * @return
     */
    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody DriverUser driverUser) {
       log.info(JSONObject.fromObject(driverUser).toString());
        return driverUserService.addDriverUser(driverUser);
    }

    /**
     * 更新司机
     * @param driverUser
     * @return
     */
    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser) {
        log.info(JSONObject.fromObject(driverUser).toString());
        return driverUserService.updateDriverUser(driverUser);
    }

    /**
     * 查询司机
     * @param driverPhone
     * @return
     */
    @GetMapping("/check-driver/{driverPhone}")
    public ResponseResult<DriverUserExistsResponse> getUser(@PathVariable("driverPhone") String driverPhone) {
        //String driverPhone = driverUser.getDriverPhone();
        ResponseResult<DriverUser> driverUserByPhone = driverUserService.getDriverUserByPhone(driverPhone);
        DriverUser driverUserDb = driverUserByPhone.getData();

        DriverUserExistsResponse response = new DriverUserExistsResponse();

        int ifExists = DriverCarConstants.DRIVER_EXISTS;
        if (driverUserDb == null) {
            ifExists = DriverCarConstants.DRIVER_NOT_EXISTS;
            response.setDriverPhone(driverPhone);
            response.setIfExists(ifExists);
        }else {
            response.setDriverPhone(driverUserDb.getDriverPhone());
            response.setIfExists(ifExists);
        }

        return ResponseResult.success(response);
    }

    /**
     * 根据车辆id查询订单需要的司机信息
     * @param carId
     * @return
     */
    @GetMapping("/get-available-driver{carId}")
    public ResponseResult<OrderDriverResponse> getAvailableDriver(@PathVariable("carId") Long carId) {
        return driverUserService.getAvailableDriver(carId);
    }

    /**
     * 根据司机手机号查询司机和车辆绑定信息
     * @param driverPhone
     * @return
     */
    @GetMapping("/driver-car-binding-relationship")
    public ResponseResult<DriverCarBindingRelationship> getDriverCarBindingRelationship(@RequestParam String driverPhone) {
        return driverCarBindingRelationshipService.getDriverCarBindingRelationshipByDriverPhone(driverPhone);
    }
}
