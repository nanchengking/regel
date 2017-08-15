package com.liushuqing.regel.core.script;

import com.liushuqing.regel.core.context.Context;

/**
 * Created by liushuqing on 2017/8/15.
 */
class After18ActionScript implements ActionScript {
    @Override
    void run(Context context) {
        String name = (String) context.get("name");
        String will = (String) context.get("will");
        System.out.println("老司机开车进行中");
        System.out.println(name + " is old enough to " + will);
    }
}
