package com.liushuqing.regel.common.req;

import java.io.Serializable;

/**
 * Created by liushuqing on 2017/8/15.
 */
public class ReqDoAction implements Serializable {
    private static final long serialVersionUID = -7813629872944239583L;

    private String condition;
    private String trueAction;
    private String falseAction;
    private String switchAction;
    private int age;
    private String name;
    private String will;


    public String getSwitchAction() {
        return switchAction;
    }

    public void setSwitchAction(String switchAction) {
        this.switchAction = switchAction;
    }

    public String getWill() {
        return will;
    }

    public void setWill(String will) {
        this.will = will;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTrueAction() {
        return trueAction;
    }

    public void setTrueAction(String trueAction) {
        this.trueAction = trueAction;
    }

    public String getFalseAction() {
        return falseAction;
    }

    public void setFalseAction(String falseAction) {
        this.falseAction = falseAction;
    }
}
