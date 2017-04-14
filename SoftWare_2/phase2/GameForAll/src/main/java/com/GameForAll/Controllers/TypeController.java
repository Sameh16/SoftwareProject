package com.GameForAll.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TypeController {
	@RequestMapping(value="/game/get-type-template/{type}",method=RequestMethod.GET)
	public String GamePage(@PathVariable String type)
	{
		type+="TemplateIndex";
		System.out.print(type);
		return type;
	}
}
