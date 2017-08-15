package com.liushuqing.regel.test.action;

import com.liushuqing.regel.core.action.AbstractAction;
import com.liushuqing.regel.core.context.Context;
import com.liushuqing.regel.core.exception.UnitRunException;

import static org.junit.Assert.assertEquals;

/**
 * Created by liushuqing on 2017/8/11.
 */
public class ActionTest extends AbstractAction {

    @Override
    public void run(Context context) throws UnitRunException {
        assertEquals(context.get("ConditionScript"), "hello");
    }
}
