package com.liushuqing.regel.test.manager;

import com.liushuqing.regel.core.RuleEngine;
import com.liushuqing.regel.core.action.GroovyAction;
import com.liushuqing.regel.core.condition.Condition;
import com.liushuqing.regel.core.condition.GroovyCondition;
import com.liushuqing.regel.core.context.SimpleContext;
import org.junit.Test;

/**
 * Created by liushuqing on 2017/8/14.
 */
public class ManagerTest {


    @Test
    public void testAge() {

        String conditionScript = "import com.liushuqing.regel.core.context.Context\n" +
                "class TestCondition {\n" +
                "    boolean start(Context contex) {\n" +
                "\t\tcontex.put(\"test\", \"hello\")\n" +
                "\t\tprintln(\" conditionScript\")\n" +
                "\t\treturn true\n" +
                "\t}\n" +
                "}";
        String actionScript = "import com.liushuqing.regel.core.context.Context\n" +
                "import static org.junit.Assert.*;\n" +
                "class TestAction {\n" +
                "    void start(Context context) {\n" +
                "\t\tprintln(\" actionScript\")\n" +
                "\t\tassertEquals(context.get(\"test\"), \"hello\")\n" +
                "\t}\n" +
                "}";

        Condition condition = new GroovyCondition(conditionScript);
        GroovyAction action = new GroovyAction(actionScript);

        condition.registerTrueUnit(action);
        action.registerUnit(action);

        RuleEngine.getInstance().setEntry(condition).start(new SimpleContext());

    }
}
