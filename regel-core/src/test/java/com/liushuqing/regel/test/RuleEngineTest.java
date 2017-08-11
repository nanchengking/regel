package com.liushuqing.regel.test;

import com.liushuqing.regel.core.RuleEngine;
import com.liushuqing.regel.core.action.AbstractAction;
import com.liushuqing.regel.core.action.Action;
import com.liushuqing.regel.core.action.GroovyAction;
import com.liushuqing.regel.core.condition.AbstractCondition;
import com.liushuqing.regel.core.condition.Condition;
import com.liushuqing.regel.core.condition.GrovvyCondition;
import com.liushuqing.regel.core.context.SimpleContext;
import com.liushuqing.regel.core.exception.AutoConfigException;
import com.liushuqing.regel.test.action.ActionTest;
import com.liushuqing.regel.test.condition.ConditionTest;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by liushuqing on 2017/8/11.
 */
public class RuleEngineTest {

    @Test
    public void testRun() {
        Condition condition = mock(AbstractCondition.class);
        Action action = mock(AbstractAction.class);

        condition.registerTrueUnit(action);
        when(condition.getResult()).thenReturn(true);

        RuleEngine.getInstance().setEntry(condition).run(new SimpleContext());
    }

    @Test
    public void testRunGroovy() throws IOException {
        String conditionScript = "import com.liushuqing.regel.core.context.Context\n" +
                "class TestCondition {\n" +
                "    boolean run(Context contex) {\n" +
                "\t\tcontex.put(\"test\", \"hello\")\n" +
                "\t\treturn true\n" +
                "\t}\n" +
                "}";
        String actionScript = "import com.liushuqing.regel.core.context.Context\n" +
                "import static org.junit.Assert.*;\n" +
                "class TestAction {\n" +
                "    void run(Context context) {\n" +
                "\t\tassertEquals(context.get(\"test\"), \"hello\")\n" +
                "\t}\n" +
                "}";
        Condition condition = new GrovvyCondition(conditionScript);
        GroovyAction action = new GroovyAction(actionScript);

        condition.registerTrueUnit(action);

        RuleEngine.getInstance().setEntry(condition).run(new SimpleContext());
    }

    @Test
    public void testJSONConfigRun() throws AutoConfigException {
        String json = "{\"type\":\"condition\",\"class\":\"" + ConditionTest.class.getName() + "\",\"true_unit\":{\"type\":\"action\",\"class\":\"" + ActionTest.class.getName() + "\"}}";
        RuleEngine.getInstance().config(json).run(new SimpleContext());
    }

}
