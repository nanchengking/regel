package com.liushuqing.regel.web.config;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liushuqing on 2017/8/15.
 */
//@Configuration
public class ViewConfig {

    @Bean
    public VelocityEngine getVelocityEngine() {
        VelocityEngine velocityEngine=new VelocityEngine();
        //velocityEngine.set
        return null;
    }

}
