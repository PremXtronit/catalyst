package com.catalyst.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("messages", "hello");
        return "NyTimes";
    }


}
