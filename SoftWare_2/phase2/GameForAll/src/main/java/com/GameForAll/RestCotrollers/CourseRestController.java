package com.GameForAll.RestCotrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CategoryRepository;
import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Category;
import com.GameForAll.models.Course;
import com.GameForAll.models.Teacher;

@RestController
public class CourseRestController {
	
	
	@Autowired
	CourseRepository CourseRepo;
	CategoryRepository CategoryRepo;
	TeacherRepository TeacherRepo;
	
	@RequestMapping(value="/{CategoryId}",method=RequestMethod.GET)
	public void ShowCourse(@PathVariable int CategoryId) 
	{
		
		return;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcourse/{TeacherId}/{CategoryId}")
	public Boolean AddCourse(@RequestBody Course course,@PathVariable long TeacherId,@PathVariable long CategoryId) 
	{
		/* Vrefication */
		System.out.println(course.toString());
		Teacher teacher = TeacherRepo.findOne(TeacherId);
		Category category = CategoryRepo.findOne(CategoryId);
		if(teacher!=null && category!=null)
		{
			course.setCategory(category);
			course.setTeacher(teacher);
			if(CourseRepo.save(course) != null)
			{
				return true;
			}
		}
		
		return false;
		
	}
}
