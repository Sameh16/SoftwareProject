package com.GameForAll.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GameController {
	@RequestMapping(value="/game",method=RequestMethod.GET)
	public String GamePage()
	{
		//hi
		return "GameIndex";
	}

}
