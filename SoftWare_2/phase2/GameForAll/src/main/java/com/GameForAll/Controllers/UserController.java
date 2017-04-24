package com.GameForAll.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student() {

		return "StudentIndex";
	}
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String teacher() {

		return "TeacherIndex";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Home()
	{
		return "Login";
	}
	

	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String HomeP()
	{
		return "Register";
	}
	
}
