package com.GameForAll.RestCotrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.GameForAll.models.Game;
import com.GameForAll.models.Teacher;


@RestController
public class CourseRestController {

	@Autowired
	private CourseRepository courseRepository ;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@RequestMapping(value = "/course/show-courses/{CategoryName}", method = RequestMethod.GET)
	public List<Course> ShowCourse(@PathVariable String CategoryName) {
		Category category = categoryRepository.findByCategoryName(CategoryName);
		List<Course> courses = new ArrayList<>();
		if (category != null) {
			courses = courseRepository.findByCategory(category);
		}
		return courses;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/course/addcourse/{categoryName}/{username}")
	public Boolean AddCourse(@RequestBody Course course, @PathVariable String categoryName, @PathVariable String username) 
	{
		Category category = categoryRepository.findByCategoryName(categoryName);
		Teacher teacher = teacherRepository.findByUsername(username);

		if (category != null && teacher != null) {
			course.setTeacher(teacher);
			course.setCategory(category);
			teacher.getCourses().add(course);
			category.getCourses().add(course);
			courseRepository.save(course);
			return true;
		} else {
			return false;
		}
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/GameInCourse/show-Course-games/{courseName}")
	public Set<Game> GetGamesInCourse(@PathVariable String courseName) 
	{
		Course course = courseRepository.findByCourseName(courseName);
		if (course!=null) {
			return course.getGames();
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/game/get-courses/{CategoryName}/{TeacherId}", method = RequestMethod.GET)
	public List<Course> GetCourses(@PathVariable String CategoryName,@PathVariable long TeacherId) {
		Category category = categoryRepository.findByCategoryName(CategoryName);
		Teacher teacher=teacherRepository.findOne(TeacherId);
		List<Course> courses = new ArrayList<>();
		if (category != null && teacher !=null) {
			courses = courseRepository.findByCategoryAndTeacher(category,teacher);
		}
		return courses;
	}	


}
