package com.mteng.web.controller;

import com.mteng.dto.ResponseContainer;
import com.mteng.service.yelp.YelpAPI;
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

    private static final String CONSUMER_KEY = "lU0rpCBvv-zC1YAb27A8oA";
    private static final String CONSUMER_SECRET = "CaQa-iJgqdA8DPCwmLuG_tDFFq0";
    private static final String TOKEN = "tTMj0fWBm318eiBzA139AbwlEeSGO_7L";
    private static final String TOKEN_SECRET = "LdFo6jCQKQztNCAKPAeSSU8vZtk";

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

    @RequestMapping(value = "/lunch", method = RequestMethod.GET)
    public String lunchAdvisor(ModelMap model) {
        ResponseContainer responseContainer;
        YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        // responseContainer = yelpApi.queryAPIv2(yelpApi,"Reading, PA","Lunch");
        responseContainer = yelpApi.queryAPIRandomly(yelpApi,"Reading, PA","restaurant");
        model.addAttribute("name",responseContainer.getName());
        model.addAttribute("address",responseContainer.getAddress().toString());
        model.addAttribute("url",responseContainer.getUrl());
        model.addAttribute("text",responseContainer.getText());
        model.addAttribute("ratings",responseContainer.getRatings());
        model.addAttribute("peopleTalkAbout",responseContainer.getPeopleTalkAbout());
        return "LoginSucessful";
    }

}
