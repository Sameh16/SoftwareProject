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
import com.GameForAll.services.CategoryServices;


@RestController
public class CategoryRestController {
	
	@Autowired
	CategoryRepository cat;
	TeacherRepository teach;
	CourseRepository courseRepository;
	
	private CategoryServices categoryServices =new CategoryServices();
	
	@RequestMapping(method=RequestMethod.POST,value="/addcategory")
	public void AddCatgeory(@RequestBody  Category c)
	{
		categoryServices.addCategory(c);
	}
	
	@RequestMapping("/showcategory/{Id}/{TID}")
	public boolean show(@PathVariable long Id , @PathVariable long TID)
	{
		Teacher teacher = teach.findOne(TID);
		Category category = cat.findOne(Id);
		
		if(teacher!=null && category!=null)
		{
			System.out.println(teacher.toString()+"\n\n"+category.toString());
			Course course =  new Course("test",20,teacher,category);
			courseRepository.save(course);
			return true;
		}
			
		return false;
	}
	
	
}
