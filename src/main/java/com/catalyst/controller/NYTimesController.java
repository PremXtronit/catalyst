package com.catalyst.controller;

import com.catalyst.common.Apis;
import com.catalyst.service.NYTimesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NYTimesController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NYTimesService nyTimesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("messages", "hello");
        return "NyTimes";
    }

    @GetMapping(value = Apis.GET_ARTICLE)
    public String getNYTimesArticles(Model model) {
        try {
            model.addAttribute("response", nyTimesService.getNYTimesArticles());
        } catch (Exception ex) {
            ex.printStackTrace();
            String res = ex.getMessage()
                    + " \n" + "     String url = \"https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=sample-key\";"
                    + " \n" + "     this url is not working";
            model.addAttribute("response", res);
        }

        return "show_response";
    }

}