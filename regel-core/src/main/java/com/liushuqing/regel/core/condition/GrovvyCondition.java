package com.liushuqing.regel.core.condition;

import com.liushuqing.regel.core.context.Context;
import com.liushuqing.regel.core.exception.UnitRunException;
import com.liushuqing.regel.core.manager.GroovyClassUtil;
import com.liushuqing.regel.core.manager.GroovyManager;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by liushuqing on 2017/8/11.
 */
public class GrovvyCondition extends AbstractCondition {

    private Class groovyClass = null;

    private String path;
    private String script;

    private Boolean result = false;

    /**
     * Groovy 条件类
     */
    public GrovvyCondition() {
        super();
    }

    /**
     * Groovy 条件类
     *
     * @param file Groovy 脚本文件
     * @throws IOException
     */
    public GrovvyCondition(File file) throws IOException {
        super();
        if (file != null && file.exists())
            this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(file);
    }

    /**
     * Groovy 条件类
     *
     * @param script Groovy 脚本
     */
    public GrovvyCondition(String script) {
        super();
        if (script != null && script.trim().length() != 0)
            this.groovyClass = GroovyManager.getInstance().getGroovyClassLoader().parseClass(script);
    }

    public void run(Context context) throws UnitRunException {
        try {
            if (this.groovyClass == null) {
                this.groovyClass = GroovyClassUtil.loadClass(this.script, this.path);
            }

            this.result = (Boolean) GroovyManager.getInstance().invokeMethod(this.groovyClass, "run", context);
        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new UnitRunException(e);
        }
    }

    public boolean getResult() {
        return this.result;
    }
}
