package com.liushuqing.regel.core.manager;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liushuqing on 2017/8/14.
 */
public class GroovyClassUtil {
    /**
     * 简单缓存类对象
     */
    private static final Map<String, Class> CLASS_MAP = new ConcurrentHashMap<>();

    /**
     * 如果 Groovy 类为空
     * 根据 path 和 script 字段获取 Groovy 类
     *
     * @param script
     * @param path
     * @return
     * @throws IOException
     */
    public static Class loadClass(String script, String path) throws IOException {
        Class groovyClass = null;
        if (StringUtils.isNotEmpty(path)) {
            groovyClass = CLASS_MAP.get(path);
        }
        if (StringUtils.isNotEmpty(script)) {
            groovyClass = CLASS_MAP.get(script);
        }
        if (groovyClass != null) {
            return groovyClass;
        }
        if (StringUtils.isNotEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(file);
            }
            CLASS_MAP.put(path, groovyClass);
        } else if (StringUtils.isNotEmpty(script)) {
            groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(script);
            CLASS_MAP.put(script, groovyClass);
        }
        return groovyClass;
    }
}
