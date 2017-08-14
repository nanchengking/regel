package com.liushuqing.regel.core.action;


import com.liushuqing.regel.core.Unit;

/**
 * Created by liushuqing on 2017/8/11.
 */
public abstract class AbstractAction implements Action {

    protected Unit unit;

    /**
     * 注册下一个动作
     * @param unit 单元
     */
    public final void registerUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * 简单的动作，如果需要连贯动作，直接调用next
     *
     * @return
     */
    public final Unit next() {
        return unit;
    }
}
