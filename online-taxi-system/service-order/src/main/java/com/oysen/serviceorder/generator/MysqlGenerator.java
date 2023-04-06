package com.oysen.serviceorder.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-order?characterEncodion=utf-8&serverTimezone=UTC",
                "root","52yt1314")
                .globalConfig(builder -> {
                    builder.author("yang").fileOverride()
                            .outputDir("E:\\WebProjects\\online-taxi-platform\\online-taxi-system\\service-order\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.oysen.serviceorder").pathInfo(Collections.singletonMap(OutputFile.mapper,
                            "E:\\WebProjects\\online-taxi-platform\\online-taxi-system\\service-order\\src\\main\\java\\com\\oysen\\serviceorder\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("order_info");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
