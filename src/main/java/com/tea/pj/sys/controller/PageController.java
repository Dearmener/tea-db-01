package com.tea.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//add
@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("doIndexUI")
    public String doIndexUI(){
        return "starter";
    }

    @RequestMapping("log/log_list")
    public String log_list(){
        return "sys/log_list";
    }

    @RequestMapping("{module}/{moduleUI}")
    public String doModuleUI(@PathVariable String moduleUI){
        System.out.println("PageController.doModuleUI");
        return "sys/"+moduleUI;
    }

}
