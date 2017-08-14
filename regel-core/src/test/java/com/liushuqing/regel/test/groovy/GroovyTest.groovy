package com.liushuqing.regel.test.groovy

import com.alibaba.fastjson.JSON
import org.junit.Test

/**
 * Created by liushuqing on 2017/8/14.
 */
class GroovyTest {
    def name;
    def ids;

    @Test
    void hello() {
        def map = new HashMap();
        map.put("fucl", "hello");
        map.put("fuck", "fuckcccc");
        def hello = JSON.toJSONString(map);
        println(hello);
    }

    public static void main(String[] args) {
        new GroovyTest().hello()
    }
}
