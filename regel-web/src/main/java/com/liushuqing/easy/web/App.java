package com.liushuqing.easy.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created by liushuqing on 2017/8/11.
 */
@SpringBootApplication(scanBasePackages = "com.liushuqing.easy")
//@ImportResource({"classpath*:spring/application.xml"})
@EnableRetry
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
