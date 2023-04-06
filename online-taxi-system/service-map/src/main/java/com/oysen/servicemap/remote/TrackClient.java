package com.oysen.servicemap.remote;

import com.oysen.internalcommon.constant.AmapConfigConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.TrackResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrackClient {

    @Value("${amap.key}")
    private String amapKey;
    @Value("${amap.sid}")
    private String amapSid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult<TrackResponse> add(String tid) {
        //拼装请求url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TRACK_ADD_URL);
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("sid=" + amapSid);
        url.append("&");
        url.append("tid=" + tid);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url.toString(), null, String.class);
        String body = stringResponseEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        //轨迹id
        String trid = data.getString("trid");
        //轨迹名称
        String trname = "";
        if (data.has("trname")) {
            trname = data.getString("trname");
        }

        TrackResponse trackResponse = new TrackResponse();
        trackResponse.setTrid(trid);
        trackResponse.setTrname(trname);

        return ResponseResult.success(trackResponse);
    }
}
