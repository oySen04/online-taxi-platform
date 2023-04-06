package com.oysen.serviceprice.controller;

import com.oysen.internalcommon.dto.PriceRule;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.PriceRuleIsNewRequest;
import com.oysen.serviceprice.service.PriceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/price-rule")
public class PriceRuleController {

    @Autowired
    private PriceRuleService priceRuleService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody PriceRule priceRule) {
        return priceRuleService.add(priceRule);
    }

    @PostMapping("/edit")
    public ResponseResult edit(@RequestBody PriceRule priceRule) {
        return priceRuleService.edit(priceRule);
    }

    /**
     * 查询最新计价规则
     * @param fareType
     * @return
     */
    @GetMapping("/get-newest-version")
    public ResponseResult<PriceRule> getNewestVersion(@RequestParam String fareType){
        return priceRuleService.getNewestVersion(fareType);
    }

    /**
     * 判断计价规则是否最新
     * @param priceRuleIsNewRequest
     * @return
     */
    @PostMapping("/is-new")
    public ResponseResult<Boolean> isNew(@RequestBody PriceRuleIsNewRequest priceRuleIsNewRequest){
        //fareType = fareType.replace("%241","$");
        return priceRuleService.isNew(priceRuleIsNewRequest.getFareType(), priceRuleIsNewRequest.getFareVersion());
    }

    /**
     * 判断城市和车型计价规则
     * @param priceRule
     * @return
     */
    @PostMapping("/if-exists")
    public ResponseResult<Boolean> ifExists(@RequestBody PriceRule priceRule){
        return priceRuleService.ifExists(priceRule);
    }
}
