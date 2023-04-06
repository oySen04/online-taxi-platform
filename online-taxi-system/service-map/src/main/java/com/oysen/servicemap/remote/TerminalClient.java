package com.oysen.servicemap.remote;

import com.oysen.internalcommon.constant.AmapConfigConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.TerminalResponse;
import com.oysen.internalcommon.responese.TrsearchResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TerminalClient {

    @Value("${amap.key}")
    private String amapKey;
    @Value("${amap.sid}")
    private String amapSid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult<TerminalResponse> add(String name, String desc) {
        //拼装请求url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TERMINAL_ADD_URL);
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("sid=" + amapSid);
        url.append("&");
        url.append("name=" + name);
        url.append("&");
        url.append("desc=" + desc);
        System.out.println("创建终端请求:" + url.toString());

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url.toString(), null, String.class);
        System.out.println("创建终端响应:" + stringResponseEntity.getBody());

        String body = stringResponseEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        String tid = data.getString("tid");
        TerminalResponse terminalResponse = new TerminalResponse();

        terminalResponse.setTid(tid);

        return ResponseResult.success(terminalResponse);
    }

    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius) {
        //拼装请求url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TERMINAL_AROUNDSEARCH_URL);
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("sid=" + amapSid);
        url.append("&");
        url.append("center=" + center);
        url.append("&");
        url.append("radius=" + radius);
        System.out.println("创建终端请求:" + url.toString());

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url.toString(), null, String.class);
        System.out.println("创建终端响应:" + stringResponseEntity.getBody());
        //解析终端搜索结果
        String body = stringResponseEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");

        List<TerminalResponse> terminalResponseList = new ArrayList<>();

        JSONArray results = data.getJSONArray("results");
        for (int i = 0; i < results.size(); i++) {
            TerminalResponse terminalResponse = new TerminalResponse();

            JSONObject jsonObject = results.getJSONObject(i);
            //desc == carId
            String desc = jsonObject.getString("desc");
//            Long carId = jsonObject.getLong("desc");
            Long carId = Long.parseLong(desc);
            String tid = jsonObject.getString("tid");

            JSONObject location = jsonObject.getJSONObject("location");
            String longitude = location.getString("longitude");
            String latitude = location.getString("latitude");

            terminalResponse.setCarId(carId);
            terminalResponse.setTid(tid);
            terminalResponse.setLongitude(longitude);
            terminalResponse.setLatitude(latitude);

            terminalResponseList.add(terminalResponse);
        }
        return ResponseResult.success(terminalResponseList);
    }

    public ResponseResult<TrsearchResponse> trsearch(String tid,Long starttime,Long endtime) {
        //拼装请求url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.TERMINAL_TRSEARCH_URL);
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("sid=" + amapSid);
        url.append("&");
        url.append("tid=" + tid);
        url.append("&");
        url.append("starttime=" + starttime);
        url.append("&");
        url.append("endtime=" + endtime);

        System.out.println("查询结果请求:" + url.toString());
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url.toString(), String.class);
        System.out.println("查询结果响应" + forEntity.getBody());
        //解析
        JSONObject result = JSONObject.fromObject(forEntity.getBody());
        JSONObject data = result.getJSONObject("data");
        int counts = data.getInt("counts");
        if (counts == 0) {
            return null;
        }
        JSONArray tracks = data.getJSONArray("tracks");
        long driverMile = 0L;
        long driverTime = 0L;

        for (int i = 0; i < tracks.size(); i++) {
            JSONObject jsonObject = tracks.getJSONObject(i);

            long distance = jsonObject.getLong("distance");
            driverMile = driverMile + distance;
            long time = jsonObject.getLong("time");
            time = time / (1000 * 60);
            driverTime = driverTime + time;
        }
        TrsearchResponse trsearchResponse = new TrsearchResponse();
        trsearchResponse.setDriverMile(driverMile);
        trsearchResponse.setDriverTime(driverTime);
        return ResponseResult.success(trsearchResponse);
    }
}
