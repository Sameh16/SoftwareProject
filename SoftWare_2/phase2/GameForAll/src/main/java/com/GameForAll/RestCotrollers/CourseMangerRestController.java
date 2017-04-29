package com.GameForAll.RestCotrollers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Course;
import com.GameForAll.models.Student;
import com.GameForAll.models.Teacher;

@RestController
public class CourseMangerRestController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	
	@Autowired
	CourseRepository courseRepository;
	
	/**
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/get-Student-courses/{username}")
	public Set<Course> getStudentCourses(@PathVariable String username)
	{
		
		Student student = studentRepository.findByUsername(username);
		Set<Course> courses=new HashSet<>();
		if(student!=null)
			courses = student.getCourses();
		return courses;
		
	}
	
	
	/**
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/get-Teacher-courses/{username}")
	public Set<Course> getTeacherCourses(@PathVariable String username)
	{
		
		Teacher teacher = teacherRepository.findByUsername(username);
		Set<Course> courses=new HashSet<>();
		if(teacher!=null)
				 courses =  teacher.getCourses();
		return courses;
		
	}
	
	/**
	 * @param courseName
	 * @param username
	 * @return
	 */
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
