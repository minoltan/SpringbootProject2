package com.spring.booking.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    private String appMode;

    @Autowired
    public ViewController(Environment environment){
        appMode = environment.getProperty("appMode");
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Minoltan");
        model.addAttribute("mode", appMode);
        return "index";
    }
}
