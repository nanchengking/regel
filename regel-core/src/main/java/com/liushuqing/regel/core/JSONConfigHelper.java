package com.liushuqing.regel.core;

import com.alibaba.fastjson.JSONObject;
import com.liushuqing.regel.core.action.Action;
import com.liushuqing.regel.core.condition.Condition;

import java.lang.reflect.Field;

/**
 * Created by liushuqing on 2017/8/11.
 */
class JSONConfigHelper {

    private static Unit parseLoop(JSONObject jo) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Unit unit = null;
        if (jo != null) {
            String type = jo.getString(Constants.JSON_FIELDNAME_TYPE);
            Class unitClass = Class.forName(jo.getString(Constants.JSON_FIELDNAME_CLASS));

            if ("action".equals(type)) {
                Action action = (Action) unitClass.newInstance();
                JSONObject fieldsJo = jo.getJSONObject(Constants.JSON_FIELDNAME_FIELDS);
                if (fieldsJo != null) {
                    configFields(fieldsJo, unitClass, action);
                }
                action.registerUnit(parseLoop(jo.getJSONObject(Constants.JSON_FIELDNAME_ACTION_UNIT)));
                unit = action;
            } else if ("condition".equals(type)) {
                Condition condition = (Condition) unitClass.newInstance();
                JSONObject fieldsJo = jo.getJSONObject(Constants.JSON_FIELDNAME_FIELDS);
                if (fieldsJo != null) {
                    configFields(fieldsJo, unitClass, condition);
                }
                condition.registerTrueUnit(parseLoop(jo.getJSONObject(Constants.JSON_FIELDNAME_CONDITION_TRUEUNIT)));
                condition.registerFalseUnit(parseLoop(jo.getJSONObject(Constants.JSON_FIELDNAME_CONDITION_FALSEUNIT)));
                unit = condition;
            } else {
                //TODO 无法识别的类型
            }
        }
        return unit;
    }

    private static void configFields(JSONObject jo, Class unitClass, Object instance) {
        if (jo != null) {
            jo.forEach( (key, value) -> {
                try {
                    Field field = unitClass.getDeclaredField(key);
                    field.setAccessible(true);
                    field.set(instance, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 解析 JSON 配置并返回入口单元
     * @param json JSON 配置
     * @return 入口单元
     * */
    public static Unit parse(String json) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Unit unit = null;

        if (json != null && json.trim().length() != 0) {
            unit = parseLoop(JSONObject.parseObject(json));
        }

        return unit;
    }

}
