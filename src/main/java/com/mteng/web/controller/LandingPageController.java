package com.mteng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mingogo on 2/26/15.
 */
@Controller
public class LandingPageController {

    @RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ModelAndView getdata() {

        ModelAndView model = new ModelAndView("LoginSucessful");
        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String readdata(ModelMap model) {
        model.addAttribute("name","mteng");
        return "LoginSucessful";
    }

}
