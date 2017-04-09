package com.GameForAll.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GameForAll.Repository.CategoryRepository;
import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.models.Category;
import com.GameForAll.models.Course;


@Service
public class CourseServices {
	@Autowired
	private CourseRepository courseRepository;
	private CategoryRepository categoryRepository;
	
	
	public List<Course> GetAllCourses(long CategoryId)
	{
		ArrayList<Course> arr=new ArrayList<>();
		Category cat =  categoryRepository.findOne(CategoryId);
		courseRepository.findByCategory(cat).forEach(arr::add);
		return arr;
		
	}
	public void addCourse(Course c)
	{
		courseRepository.save(c);
	}

}
