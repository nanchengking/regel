package com.liushuqing.regel.web.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liushuqing on 2017/8/11.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class CommonController {

    @RequestMapping("/")
    @ResponseBody
    public String getByKey(String key) {
        return "i'm fun~";
    }
}
