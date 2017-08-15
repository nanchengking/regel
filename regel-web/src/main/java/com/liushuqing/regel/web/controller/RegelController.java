package com.liushuqing.regel.web.controller;

import com.liushuqing.regel.common.req.ReqPutScript;
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

    @RequestMapping("putScript")
    @ResponseBody
    public boolean putScript(@RequestBody ReqPutScript putScript) {
        if (putScript == null) {
            return false;
        }
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
}
