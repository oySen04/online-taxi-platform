package com.oysen.servicemap.service;

import com.oysen.internalcommon.constant.AmapConfigConstants;
import com.oysen.internalcommon.constant.CommonStatusEnum;
import com.oysen.internalcommon.dto.DicDistrict;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.servicemap.mapper.DicDistrictMapper;
import com.oysen.servicemap.remote.MapDicDistrictClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicDistrictService {

    @Autowired
    private MapDicDistrictClient mapDicDistrictClient;
    @Autowired
    private DicDistrictMapper dicDistrictMapper;

    public ResponseResult iniDistrict(String keywords) {

        String dicDistrictResult = mapDicDistrictClient.dicDistrict(keywords);
        System.out.println(dicDistrictResult);

        //解析结果
        JSONObject dicDistrictJsonObject = JSONObject.fromObject(dicDistrictResult);
        int status = dicDistrictJsonObject.getInt(AmapConfigConstants.STATUS);
        if (status != 1) {
            return ResponseResult.fail(CommonStatusEnum.MAP_DISTRICT_ERROR.getCode(),CommonStatusEnum.MAP_DISTRICT_ERROR.getValue());
        }
        JSONArray countryJsonArray = dicDistrictJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
        for (int country = 0; country < countryJsonArray.size(); country++) {
            JSONObject countryJsonObject = countryJsonArray.getJSONObject(country);
            String countryAddressCode = countryJsonObject.getString(AmapConfigConstants.ADCODE);
            String countryAddressName = countryJsonObject.getString(AmapConfigConstants.NAME);
            String countryParentAddressCode = "0";
            String countryLevel = countryJsonObject.getString(AmapConfigConstants.LEVEL);

            insertDicDistrict(countryAddressCode,countryAddressName,countryLevel,countryParentAddressCode);

            JSONArray proviceJsonArray = countryJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
            for (int provice = 0; provice < proviceJsonArray.size(); provice++) {
                JSONObject proviceJsonObject = proviceJsonArray.getJSONObject(provice);
                String proviceAddressCode = proviceJsonObject.getString(AmapConfigConstants.ADCODE);
                String proviceAddressName = proviceJsonObject.getString(AmapConfigConstants.NAME);
                String provicePaarentAddressCode = countryAddressCode;
                String proviceLevel = proviceJsonObject.getString(AmapConfigConstants.LEVEL);

                insertDicDistrict(proviceAddressCode,proviceAddressName,proviceLevel,provicePaarentAddressCode);

                JSONArray cityArray = proviceJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
                for (int city = 0; city < proviceJsonArray.size(); city++) {
                    JSONObject cityJsonObject = cityArray.getJSONObject(city);
                    String cityAddressCode = cityJsonObject.getString(AmapConfigConstants.ADCODE);
                    String cityAddressName = cityJsonObject.getString(AmapConfigConstants.NAME);
                    String cityPaarentAddressCode = proviceAddressCode;
                    String cityLevel = cityJsonObject.getString(AmapConfigConstants.LEVEL);

                    insertDicDistrict(cityAddressCode,cityAddressName,cityLevel,cityPaarentAddressCode);

                    JSONArray districtArray = cityJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
                    for (int district = 0; district < proviceJsonArray.size(); district++) {
                        JSONObject districtJsonObject = districtArray.getJSONObject(district);
                        String districtAddressCode = districtJsonObject.getString(AmapConfigConstants.ADCODE);
                        String districtAddressName = districtJsonObject.getString(AmapConfigConstants.NAME);
                        String districtPaarentAddressCode = cityAddressCode;
                        String districtLevel = districtJsonObject.getString(AmapConfigConstants.LEVEL);

                        if (districtLevel.equals(AmapConfigConstants.STREET)) {
                            continue;
                        }

                        insertDicDistrict(districtAddressCode,districtAddressName,districtLevel,districtPaarentAddressCode);
                    }
                }
            }

        }
        return ResponseResult.success("");
    }

    public void insertDicDistrict(String addressCode, String addressName,String level, String parentAddressCode) {
        //数据库对象
        DicDistrict district = new DicDistrict();
        district.setAddressCode(addressCode);
        district.setAddressName(addressName);
        int levelInt = generateLevel(level);
        district.setLevel(levelInt);

        district.setParentAddressCode(parentAddressCode);
        //插入数据库
        dicDistrictMapper.insert(district);
    }
    public int generateLevel(String level) {
        int levelInt = 0;
        if (level.trim().equals("country")) {
            levelInt = 0;
        }else if (level.trim().equals("province")) {
            levelInt = 1;
        }else if (level.trim().equals("city")) {
            levelInt = 2;
        }else if (level.trim().equals("district")) {
            levelInt = 3;
        }
        return levelInt;
    }
}
