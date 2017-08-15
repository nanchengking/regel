package com.liushuqing.regel.core.script.loader;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liushuqing on 2017/8/15.
 */
@Service
public class MemaryScriptLoader implements ScriptLoader {

    private Map<String, String> map = new ConcurrentHashMap<>();

    @Override
    public String get(String name) {
        return map.get(name);
    }

    @Override
    public boolean put(String name, String script) {
        map.put(name, script);
        return true;
    }

    @Override
    public boolean remove(String name) {
        map.remove(name);
        return true;
    }

    @Override
    public Map<String, String> getAll() {
        return map;
    }
}
