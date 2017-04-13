package com.GameForAll.RestCotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.models.Course;
import com.GameForAll.models.Student;

@RestController
public class CourseMangerRestController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@RequestMapping(value = "/course/get-student-courses/{username}")
	public List<Course> getCourses(@PathVariable String username)
	{
		
		Student student = studentRepository.findByUsername(username);
		List<Course> courses = (List<Course>) student.getCourses();
		return courses;
		
	}
	
	@RequestMapping(value = "/student/add-course/{username}/{courseName}")
	public boolean SetCourseToStudent(@PathVariable String courseName,@PathVariable String username)
	{
		Course course = courseRepository.findByCourseName(courseName);
		Student student = studentRepository.findByUsername(username);
		if(course!=null && student!=null)
		{
			student.getCourses().add(course);
			course.getStudents().add(student);
			
			return true;
		}
		return false;
	}
	
	
}
