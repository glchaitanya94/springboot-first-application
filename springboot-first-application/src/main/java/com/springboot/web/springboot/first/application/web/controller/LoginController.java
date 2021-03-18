package com.springboot.web.springboot.first.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.springboot.first.application.web.service.LoginService;

/*
 * dispatcherServlet - used for mapping
 * login is mapped to login controller login message method
 * once dispatcher gets back the message, it looks for views.
 * with name hello world. If not found, shows an error page
 * */

@Controller
public class LoginController {

	// Injected automatically
	@Autowired
	LoginService loginservice;

	/*
	 * @RequestMapping(value="/login", method=RequestMethod.GET) //request mapping
	 * is for GET, POST or any other method
	 * 
	 * @ResponseBody responseBody can send the message back in json or string
	 * directly it does not check for jsp view if request mapping is used
	 * 
	 * //public String loginMessage(@RequestParam String name, ModelMap model) {
	 * public String loginMessage(ModelMap model) { return "login"; }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.put("name", "chaitanya");
		model.put("pasword", "chaitanya");
		return "welcome";
	}

	/*
	 * @RequestMapping(value="/login", method=RequestMethod.POST) public String
	 * showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam
	 * String password) { boolean isValidUser = loginservice.validateUser(name,
	 * password); System.out.println("xxxxxxxxxxxxxxxx:: "+isValidUser);
	 * if(isValidUser) { model.put("name", name); model.put("password", password);
	 * return "welcome"; }else { //model.put("errorMessage", "invalid cedentials");
	 * //return "login"; model.put("errorMessage", "Invalid Credentials!!"); return
	 * "login"; } }
	 */
}