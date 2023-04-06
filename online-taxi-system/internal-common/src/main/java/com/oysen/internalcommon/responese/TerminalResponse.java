package com.oysen.internalcommon.responese;

import lombok.Data;

@Data
public class TerminalResponse {

    private String tid;

    private Long carId;

    private String longitude;
    private String latitude;

    /**
     * 载客里程（米）
     */
    private Long driveMile;

    /**
     * 载客时间(分)
     */
    private Long driveTime;

}
