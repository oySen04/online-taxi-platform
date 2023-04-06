package com.oysen.serviceprice.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.ForecastPriceDTO;
import com.oysen.serviceprice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastPriceController {

    @Autowired
    private PriceService priceService;

    /**
     * 计算预估价格
     * @param forecastPriceDTO
     * @return
     */
    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO) {

        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String desLongitude = forecastPriceDTO.getDesLongitude();
        String desLatitude = forecastPriceDTO.getDesLatitude();
        String cityCode = forecastPriceDTO.getCityCode();
        String vehicleType = forecastPriceDTO.getVehicleType();

        return priceService.forecastPrice(depLongitude,depLatitude,desLongitude,desLatitude,cityCode,vehicleType);
    }

    /**
     * 计算实际价格
     * @param distance
     * @param duration
     * @param cityCode
     * @param vehicleType
     * @return
     */
    @PostMapping("/calculate-price")
    public ResponseResult<Double> calculatePrice(@RequestParam Integer distance, @RequestParam Integer duration, @RequestParam String cityCode, @RequestParam String vehicleType) {
        return priceService.calculatePrice(distance, duration, cityCode, vehicleType);
    }
}
