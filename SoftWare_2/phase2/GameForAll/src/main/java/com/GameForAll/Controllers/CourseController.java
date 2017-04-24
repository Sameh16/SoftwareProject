package com.GameForAll.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {
	@RequestMapping(value="/course",method=RequestMethod.GET)
	public String HomePage()
	{
		return "CourseIndex";
	}
	
	
	@RequestMapping(value="/CourseInCategory",method=RequestMethod.GET)
	public String CourseInCategory()
	{
		return "CourseInCategory";
	}
	
	

}
