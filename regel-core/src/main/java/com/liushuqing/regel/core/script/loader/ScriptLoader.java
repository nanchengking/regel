package com.liushuqing.regel.core.script.loader;

import java.util.Map;

/**
 * Created by liushuqing on 2017/8/15.
 */
public interface ScriptLoader {

    /**
     * 获取一个脚本
     *
     * @param name
     * @return
     */
    public String get(String name);

    /**
     * 添加或者修改一个脚本
     *
     * @param name
     * @return
     */
    public boolean put(String name, String script);

    /**
     * 删除一个脚本
     *
     * @param name
     * @return
     */
    public boolean remove(String name);

    public Map<String, String> getAll();


}

