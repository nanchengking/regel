package com.liushuqing.regel.core.script.groovy

import com.liushuqing.regel.core.context.Context

/**
 * Created by liushuqing on 2017/8/15.
 */
class AgeConditionSctipt implements ConditionScript {
    @Override
    boolean run(Context context) {
        int age = (Integer) context.get("age");
        if (age < 18) {
            return false;
        }
        return true;
    }
}
