package com.oysen.servicemap.remote;

import com.oysen.internalcommon.constant.AmapConfigConstants;
import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.request.PointDTO;
import com.oysen.internalcommon.request.PointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class PointClient {

    @Value("${amap.key}")
    private String amapKey;
    @Value("${amap.sid}")
    private String amapSid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult upload(PointRequest pointRequest) {
        //拼装请求url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.POINT_UPLOAD_URL);
        url.append("?");
        url.append("key=" + amapKey);
        url.append("&");
        url.append("sid=" + amapSid);
        url.append("&");
        url.append("tid=" + pointRequest.getTid());
        url.append("&");
        url.append("trid=" + pointRequest.getTrid());
        url.append("&");
        url.append("points=");
        PointDTO[] points = pointRequest.getPoints();
        //url.append("[");
        url.append("%5B");
        for (PointDTO p: points
             ) {
            //url.append("{");
            url.append("%7B");
            String locatetime = p.getLocatetime();
            String location = p.getLocation();
            //url.append("\"location\"");
            url.append("%22location%22");
            url.append("%3A");
            url.append("%22"+location+"%22");
            url.append("%2C");

            url.append("%22locatetime%22");
            url.append("%3A");
            url.append(locatetime);

            //url.append("}");
            url.append("%7D");
        }
        //url.append("]");
        url.append("%5D");

        System.out.println("高德地图请求:" + url.toString());
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URI.create(url.toString()), null, String.class);
        System.out.println("高德地图响应:" + stringResponseEntity.getBody());
        return ResponseResult.success();
    }
}
