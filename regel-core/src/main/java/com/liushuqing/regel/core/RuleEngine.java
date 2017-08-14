package com.liushuqing.regel.core;

import com.liushuqing.regel.core.context.Context;
import com.liushuqing.regel.core.exception.AutoConfigException;
import com.liushuqing.regel.core.exception.UnitRunException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by liushuqing on 2017/8/11.
 */
public class RuleEngine {
    private static RuleEngine sharedInstance = new RuleEngine();

    /**
     * 获取规则引擎实例
     *
     * @return 规则引擎共享实例
     */
    public static RuleEngine getInstance() {
        return sharedInstance;
    }

    private Unit entry;

    private RuleEngine() {
    }

    /**
     * 执行循环遍历单元
     * 如果当前是condition，那么会执行当前condition，得到result，根据result，执行true或者false的action
     * 如果当前是action，那么会执行当前action，然后执行下一个unit（可能是action，也能是condition）
     *
     * @param unit    单元
     * @param context 执行上下文
     */
    private void runLoop(Unit unit, Context context) {
        if (unit != null) {
            try {
                unit.run(context);
                runLoop(unit.next(), context);
            } catch (UnitRunException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 运行规则引擎
     *
     * @param context 上下文
     */
    public void start(Context context) {
        if (context == null) throw new IllegalArgumentException("Context should not be null.");
        runLoop(this.entry, context);
    }

    /**
     * 设置入口单元
     *
     * @param unit 单元
     * @return 规则引擎
     */
    public RuleEngine setEntry(Unit unit) {
        this.entry = unit;
        return this;
    }

    /**
     * 获取入口单元
     *
     * @return 入口单元
     */
    public Unit getEntry() {
        return this.entry;
    }

    /**
     * 使用 JSON 配置文件自动装配规则引擎
     *
     * @param json JSON 配置文件
     */
    public RuleEngine config(String json) throws AutoConfigException {
        if (StringUtils.isNotEmpty(json)) {
            try {
                setEntry(JSONConfigHelper.parse(json));
            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                throw new AutoConfigException(e);
            }
        }
        return this;
    }

}
