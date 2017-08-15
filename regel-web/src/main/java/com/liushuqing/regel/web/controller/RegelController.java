package com.liushuqing.regel.web.controller;

import com.liushuqing.regel.common.req.ReqDoAction;
import com.liushuqing.regel.common.req.ReqPutScript;
import com.liushuqing.regel.core.RuleEngine;
import com.liushuqing.regel.core.action.GroovyAction;
import com.liushuqing.regel.core.condition.Condition;
import com.liushuqing.regel.core.condition.GroovyCondition;
import com.liushuqing.regel.core.context.Context;
import com.liushuqing.regel.core.context.SimpleContext;
import com.liushuqing.regel.core.script.loader.ScriptLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by liushuqing on 2017/8/15.
 */
@Controller
@RequestMapping("/regel")
public class RegelController {

    @Resource
    private ScriptLoader scriptLoader;

    @RequestMapping(value = "putScript")
    @ResponseBody

    public boolean putScript(@RequestBody ReqPutScript putScript) {
        if (putScript == null) {
            return false;
        }
        scriptLoader.put(putScript.getName(), putScript.getScript());
        return true;
    }

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("scripts", scriptLoader.getAll());
        return "test";
    }

    @RequestMapping("getScript")
    @ResponseBody
    public String getScript(@RequestParam String name) {
        return scriptLoader.get(name);
    }


    @RequestMapping("doAction")
    @ResponseBody
    public String doAction(@RequestBody ReqDoAction reqDoAction) {

        Condition condition = new GroovyCondition(scriptLoader.get(reqDoAction.getCondition()));
        GroovyAction trueAction = new GroovyAction(scriptLoader.get(reqDoAction.getTrueAction()));
        GroovyAction falseAction = new GroovyAction(scriptLoader.get(reqDoAction.getFalseAction()));

        condition.registerTrueUnit(trueAction);
        condition.registerFalseUnit(falseAction);

        Context<String> context = new SimpleContext();
        context.put("age", reqDoAction.getAge());
        context.put("name", reqDoAction.getName());
        context.put("will", reqDoAction.getWill());
        RuleEngine.getInstance().setEntry(condition).start(context);
        String executeResult = context.getResult();

        return executeResult;
    }

}
