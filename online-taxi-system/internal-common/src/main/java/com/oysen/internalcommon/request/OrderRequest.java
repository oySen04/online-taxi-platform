package com.oysen.internalcommon.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {
    private Long orderId;
    //乘客id
    private Long passengerId;
    //乘客电话
    private String passengerPhone;

    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String departTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String orderTime;

    private String departure;
    private String depLongitude;
    private String depLatitude;

    private String destination;
    private String desLongitude;
    private String desLatitude;

    private Integer encrypt;

    private String fareType;
    private String vehicleType;
    //运价版本
    private Integer fareVersion;
    //设备号
    private String deviceCode;

    /**
     * 司机去接乘客出发时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toPickUpPassengerTime;

    /**
     * 去接乘客时，司机的经度
     */
    private String toPickUpPassengerLongitude;

    /**
     * 去接乘客时，司机的纬度
     */
    private String toPickUpPassengerLatitude;

    /**
     * 去接乘客时，司机的地点
     */
    private String toPickUpPassengerAddress;

    /**
     * 接到乘客，乘客上车经度
     */
    private String pickUpPassengerLongitude;

    /**
     * 接到乘客，乘客上车纬度
     */
    private String pickUpPassengerLatitude;

    /**
     * 乘客下车经度
     */
    private String passengerGetoffLongitude;

    /**
     * 乘客下车纬度
     */
    private String passengerGetoffLatitude;

    /**
     * 载客里程（米）
     */
    private Long driveMile;

    /**
     * 载客时间(分)
     */
    private Long driveTime;
}
