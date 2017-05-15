package com.GameForAll.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController {
	
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String GamePage() {

		return "GameIndex";
	}

	@RequestMapping(value = "/GameInCourse", method = RequestMethod.GET)
	public String CourseGamesPage() {
		return "GameInCourse";
	}

	@RequestMapping(value = "/playGameQ", method = RequestMethod.GET)
	public String GamePage1() {

		return "playGame";
	}
	
	
	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public String GamePage2() {

		return "comment";
	}
	
	@RequestMapping(value = "/showComments", method = RequestMethod.GET)
	public String GamePage3() {

		return "showComment";
	}
	
	@RequestMapping(value = "/showNotifications", method = RequestMethod.GET)
	public String Page4() {

		return "notify";
	}

}
