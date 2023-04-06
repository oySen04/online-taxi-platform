package com.oysen.serviceprice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oysen.internalcommon.constant.CommonStatusEnum;
import com.oysen.internalcommon.dto.PriceRule;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.ForecastPriceDTO;
import com.oysen.internalcommon.responese.DirectionResponse;
import com.oysen.internalcommon.responese.ForecastPriceResponse;
import com.oysen.internalcommon.util.BigDecimalUtils;
import com.oysen.serviceprice.mapper.PriceRuleMapper;
import com.oysen.serviceprice.remote.ServiceMapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class PriceService {

    @Autowired
    private ServiceMapClient serviceMapClient;
    @Autowired
    private PriceRuleMapper priceRuleMapper;

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
        log.info("调用地图服务，查询距离与时长");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDesLongitude(desLongitude);
        forecastPriceDTO.setDesLatitude(desLatitude);

        forecastPriceDTO.setCityCode(cityCode);
        forecastPriceDTO.setVehicleType(vehicleType);

        ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
        Integer distance = direction.getData().getDistance();
        Integer duration = direction.getData().getDuration();
        log.info("距离: " + distance + ",时长: " + duration);

        log.info("读取计价规格");
//        Map<String,Object> queryMap = new HashMap<>();
//        queryMap.put("city_code",cityCode);
//        queryMap.put("vehicle_type",vehicleType);

        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_code",cityCode);
        queryWrapper.eq("vehicle_type",vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);
        if (priceRules.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }
        PriceRule priceRule = priceRules.get(0);

        log.info("根据距离、时长和计价规则计算价格");

        double price = getPrice(distance, duration, priceRule);

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        forecastPriceResponse.setCityCode(cityCode);
        forecastPriceResponse.setVehicleType(vehicleType);
        forecastPriceResponse.setFareType(priceRule.getFareType());
        forecastPriceResponse.setFareVersion(priceRule.getFareVersion());

        return ResponseResult.success(forecastPriceResponse);
    }

    /**
     * 计算实际价格
     * @param distance
     * @param duration
     * @param cityCode
     * @param vehicleType
     * @return
     */
    public ResponseResult<Double> calculatePrice( Integer distance, Integer duration, String cityCode, String vehicleType) {
        //查询计价规则
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_code",cityCode);
        queryWrapper.eq("vehicle_type",vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);
        if (priceRules.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }

        PriceRule priceRule = priceRules.get(0);

        log.info("根据距离、时长和计价规则计算价格");

        double price = getPrice(distance, duration, priceRule);
        return ResponseResult.success(price);
    }

    /**
     * 根据距离和时长计算最终价格
     * @param distance 距离
     * @param duration 时长
     * @param priceRule 计价规则
     * @return
     */
    public double getPrice(Integer distance, Integer duration, PriceRule priceRule) {
        //BigDecimal price = new BigDecimal(0);
        double price = 0;
        //起步价
        Double startFare = priceRule.getStartFare();
        /*BigDecimal startFareDecimal = new BigDecimal(startFare);
        price = price.add(startFareDecimal);*/
        price = BigDecimalUtils.add(price,startFare);

        //里程费
        /*BigDecimal distanceDecimal = new BigDecimal(distance);
        //总里程
        BigDecimal distanceMileDecimal = distanceDecimal.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP);*/
        double distanceMile = BigDecimalUtils.divide(distance,1000);
        //起步里程
        //Integer startMile = priceRule.getStartMile();
        double startMile = (double) priceRule.getStartMile();
        //BigDecimal startMileDecimal = new BigDecimal(startMile);
        //double distanceSubtract = distanceMileDecimal.subtract(startMileDecimal).doubleValue();
        double distanceSubtract = BigDecimalUtils.substract(distanceMile,startMile);
        //最终收费里程
        //Double mile = distanceSubtract < 0 ? 0 : distanceSubtract;
        double mile = distanceSubtract < 0 ? 0 : distanceSubtract;
        //BigDecimal mileDecimal = new BigDecimal(mile);
        //计程单价
        //Double unitPricePerMile = priceRule.getUnitPricePerMile();
        double unitPricePerMile = priceRule.getUnitPricePerMile();
        //BigDecimal unitPricePerMileDecimal = new BigDecimal(unitPricePerMile);
        //里程价
        //BigDecimal mileFare = mileDecimal.multiply(unitPricePerMileDecimal).setScale(2, BigDecimal.ROUND_HALF_UP);
        double mileFare = BigDecimalUtils.multiply(mile,unitPricePerMile);
        //price = price.add(mileFare);
        price = BigDecimalUtils.add(price,mileFare);

        //时长费
        //BigDecimal time = new BigDecimal(duration);
        //时长分钟数
        //BigDecimal timeDecimal = time.divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP);
        double timeMinute = BigDecimalUtils.divide(duration,60);
        //计时单价
        //Double unitPricePerMinute = priceRule.getUnitPricePerMinute();
        double unitPricePerMinute = priceRule.getUnitPricePerMinute();
        //BigDecimal unitPricePerMinuteDecimal = new BigDecimal(unitPricePerMinute);
        //时长费用
        //BigDecimal timeFare = timeDecimal.multiply(unitPricePerMinuteDecimal);
        double timeFare = BigDecimalUtils.multiply(timeMinute,unitPricePerMinute);
        //price = price.add(timeFare);
        price = BigDecimalUtils.add(price,timeFare);

        BigDecimal priceBigDecimal = BigDecimal.valueOf(price);
        priceBigDecimal = priceBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);

        return priceBigDecimal.doubleValue();
    }

/*    public static void main(String[] args) {
        PriceRule priceRule = new PriceRule();
        priceRule.setUnitPricePerMile(18.0);
        priceRule.setUnitPricePerMinute(5.0);
        priceRule.setStartFare(100.0);
        priceRule.setStartMile(5);
        System.out.println(getPrice(5600,1600,priceRule));
    }*/
}
