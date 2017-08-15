package com.liushuqing.regel.core.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushuqing on 2017/8/11.
 */
public class SimpleContext<T> implements Context<T> {

    private Map<String, Object> map;

    private T result;

    public SimpleContext() {
        this.map = new HashMap<String, Object>();
    }

    public void put(String key, Object value) {
        this.map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    @Override
    public boolean setResult(T result) {
        this.result = result;
        return true;
    }

    @Override
    public T getResult() {
        return this.result;
    }
}
