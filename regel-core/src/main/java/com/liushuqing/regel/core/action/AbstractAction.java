package com.liushuqing.regel.core.action;


import com.liushuqing.regel.core.Unit;

/**
 * Created by liushuqing on 2017/8/11.
 */
public abstract class AbstractAction implements Action {

    protected Unit unit;

    public final void registerUnit(Unit unit) {
        this.unit = unit;
    }

    public final Unit next() {
        return unit;
    }
}
