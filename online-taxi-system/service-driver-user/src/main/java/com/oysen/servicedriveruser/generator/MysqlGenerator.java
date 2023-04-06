package com.oysen.servicedriveruser.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-driver-user?characterEncodion=utf-8&serverTimezone=UTC",
                "root","52yt1314")
                .globalConfig(builder -> {
                    builder.author("yang").fileOverride()
                            .outputDir("E:\\WebProjects\\online-taxi-platform\\online-taxi-system\\service-driver-user\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.oysen.servicedriveruser").pathInfo(Collections.singletonMap(OutputFile.mapper,
                            "E:\\WebProjects\\online-taxi-platform\\online-taxi-system\\service-driver-user\\src\\main\\java\\com\\oysen\\servicedriveruser\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("driver_user_work_status");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
