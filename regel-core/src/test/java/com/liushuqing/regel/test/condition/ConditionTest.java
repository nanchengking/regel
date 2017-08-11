package com.liushuqing.regel.test.condition;

import com.liushuqing.regel.core.condition.AbstractCondition;
import com.liushuqing.regel.core.context.Context;
import com.liushuqing.regel.core.exception.UnitRunException;

/**
 * Created by liushuqing on 2017/8/11.
 */
public class ConditionTest extends AbstractCondition {
    @Override
    public boolean getResult() {
        return true;
    }

    @Override
    public void run(Context context) throws UnitRunException {
        context.put("test", "hello");
    }
}
