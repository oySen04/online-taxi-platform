package com.oysen.apipassenger.service;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.oysen.apipassenger.remote.ServicePriceClient;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.ForecastPriceDTO;
import com.oysen.internalcommon.responese.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ForecastPriceService {

    @Autowired
    private ServicePriceClient servicePriceClient;

    /**
     * 根据出发地和目的地经纬度计算预估价格
     * @param depLongitude
     * @param depLatitude
     * @param desLongitude
     * @param desLatitude
     * @return
     */
    public ResponseResult forecastPrice(String depLongitude, String depLatitude, String desLongitude, String desLatitude,String cityCode,String vehicleType) {

        log.info("出发地经度" + depLongitude);
        log.info("出发地纬度" + depLatitude);
        log.info("目的地经度" + desLongitude);
        log.info("目的地纬度" + desLatitude);
        log.info("调用计价服务");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDesLongitude(desLongitude);
        forecastPriceDTO.setDesLatitude(desLatitude);
        forecastPriceDTO.setCityCode(cityCode);
        forecastPriceDTO.setVehicleType(vehicleType);

        ResponseResult<ForecastPriceResponse> forecast = servicePriceClient.forecast(forecastPriceDTO);
        //double price = forecast.getData().getPrice();

        /*ForecastPriceResponse data = forecast.getData();
        double price = data.getPrice();
        String fareType = data.getFareType();

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        forecastPriceResponse.setCityCode(cityCode);
        forecastPriceResponse.setVehicleType(vehicleType);*/

        return ResponseResult.success(forecast.getData());
    }
}
