package com.oysen.internalcommon.responese;

import lombok.Data;

@Data
public class ForecastPriceResponse {

    private double price;

    private String cityCode;
    private String vehicleType;

    private String fareType;
    private Integer fareVersion;
}
