package com.oysen.serviceorder.remote;

import com.oysen.internalcommon.dto.PriceRule;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.PriceRuleIsNewRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;

@FeignClient("service-price")
public interface ServicePriceClient {

    @PostMapping("/price-rule/is-new")
    public ResponseResult<Boolean> isNew(@RequestBody PriceRuleIsNewRequest priceRuleIsNewRequest);

    @RequestMapping(method = RequestMethod.GET,value ="/price-rule/if-exists")
    public ResponseResult<Boolean> ifPriceRuleExists(@RequestBody PriceRule priceRule);

    @RequestMapping(method = RequestMethod.POST,value = "/price-rule/calculate-price")
    public ResponseResult<Double> calculatePrice(@RequestParam Integer distance, @RequestParam Integer duration, @RequestParam String cityCode, @RequestParam String vehicleType);

}
