package com.mteng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LandingPageController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		// model.addObject("title", "Spring Security Hello World");
		// model.addObject("message", "This is welcome page!");
		model.addObject("title", "FitchRatingsAPIs - Please refer to README.md for usages.");
		// model.addObject("message", "Please refer to README.md for usages.");
		model.setViewName("index");
		return model;

	}

	// @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	@RequestMapping(value = "/secret**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Projected resources.");
		model.addObject("message", "Protected resources.");
		// model.setViewName("admin");
		model.setViewName("secret");

		return model;

	}

}