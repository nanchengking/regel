package com.liushuqing.regel.core.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushuqing on 2017/8/11.
 */
public class SimpleContext implements Context {

    private Map<String, Object> map;

    public SimpleContext() {
        this.map = new HashMap<String, Object>();
    }

    public void put(String key, Object value) {
        this.map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }
}
