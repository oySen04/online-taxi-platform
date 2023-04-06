package com.oysen.servicepay.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {

    /**
     * 应用id
     */
    private String appId;
    /**
     * 应用私钥
     */
    private String appPrivateKey;
    /**
     * 支付宝公钥
     */
    private String publicKey;
    /**
     * 内网穿透地址
     */
    private String notifyUrl;

    @PostConstruct
    public void init() {
        //基础配置
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";
        //业务配置
        config.appId = this.appId;
        config.merchantPrivateKey = this.appPrivateKey;
        config.alipayPublicKey = this.publicKey;
        config.notifyUrl = this.notifyUrl;

        Factory.setOptions(config);
        System.out.println("支付宝配置初始化");
    }
}
