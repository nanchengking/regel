package com.liushuqing.regel.core.script

import com.liushuqing.regel.core.context.Context

/**
 * Created by liushuqing on 2017/8/15.
 */
public interface ConditionScript {
    public boolean run(Context context);
}