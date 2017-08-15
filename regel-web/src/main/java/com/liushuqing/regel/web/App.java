package com.liushuqing.regel.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created by liushuqing on 2017/8/11.
 */
@SpringBootApplication(scanBasePackages = "com.liushuqing.regel")
@EnableAutoConfiguration
//@ImportResource({"classpath*:spring/application.xml"})
@EnableRetry
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
