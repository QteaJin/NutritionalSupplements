package ua.od.telegrambot.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.od.telegrambot.bean.UserBean;

@RestController
public class RegistrationController {

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registrUser(@RequestBody UserBean bean) {
		System.out.println(bean.getName());
		//System.out.println("register");
		return "Ok";
		
	}
}
