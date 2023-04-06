package com.oysen.servicemap.remote;

import com.oysen.internalcommon.constant.AmapConfigConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.ServiceMapResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.soap.SAAJResult;

@Service
public class ServiceClient {
    @Value("${amap.key}")
    private String amapKey;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult add(String name) {
        //拼装请求url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.SERVICE_ADD_URL);
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("name=" + name);

        ResponseEntity<String> forEntity = restTemplate.postForEntity(url.toString(), null, String.class);
        String body = forEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        String sid = data.getString("sid");

        ServiceMapResponse serviceMapResponse = new ServiceMapResponse();
        serviceMapResponse.setSid(sid);

        return ResponseResult.success(serviceMapResponse);
    }
}
