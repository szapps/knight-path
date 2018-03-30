
package com.szilli.cn.excercise.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szilli.cn.excercise.form.KnightPositionsForm;

@Controller
public class WelcomeController {

	@Value("${application.message:Knights Moves}")
	private String message = "Knights Moves";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("knightPositions", new KnightPositionsForm());
		return "welcome";
	}

}
