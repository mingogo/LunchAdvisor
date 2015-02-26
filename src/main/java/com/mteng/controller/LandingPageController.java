package com.mteng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LandingPageController {

	@RequestMapping(value = { "/", "/welcome**", "index"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "FitchRatingsAPIs - Please refer to README.md for usages.");
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = { "result" }, method = RequestMethod.GET)
	public ModelAndView resultPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "testResult");
		model.setViewName("LoginSucessful");
		return model;
	}
}