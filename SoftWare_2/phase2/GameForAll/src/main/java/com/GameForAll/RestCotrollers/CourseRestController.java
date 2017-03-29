package com.GameForAll.RestCotrollers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.models.Course;

@RestController
public class CourseRestController {
	private Course course = new Course();
	
	@RequestMapping(value="/{CategoryId}",method=RequestMethod.GET)
	public ArrayList<Course> ShowCourse(@PathVariable int CategoryId) 
	{
		
		return course.SelectAll(CategoryId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcourse")
	public Boolean AddCourse(@RequestBody Course course) 
	{
		return course.SaveCourse(course);
	}
}
