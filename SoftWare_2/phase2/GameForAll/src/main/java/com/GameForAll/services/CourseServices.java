package com.GameForAll.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.models.Course;


@Service
public class CourseServices {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> GetAllCourses(int CategoryName)
	{
		ArrayList<Course> arr=new ArrayList<>();
		courseRepository.findByCategory(CategoryName).forEach(arr::add);
		return arr;
		
	}
	public void addCourse(Course c)
	{
		courseRepository.save(c);
	}

}
