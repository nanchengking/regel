package com.liushuqing.regel.core.action;

import com.liushuqing.regel.core.Unit;

/**
 * Created by liushuqing on 2017/8/11.
 */
public interface Action extends Unit {

    /**
     * 注册单元
     * @param unit 单元
     * */
    public void registerUnit(Unit unit);

}
