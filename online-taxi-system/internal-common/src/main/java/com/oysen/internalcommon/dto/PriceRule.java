package com.oysen.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PriceRule implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cityCode;

    private String vehicleType;

    private Double startFare;

    private Integer startMile;

    private Double unitPricePerMile;

    private Double unitPricePerMinute;

    /**
     * 运价版本号
     */
    private Integer fareVersion;

    private String fareType;
}
