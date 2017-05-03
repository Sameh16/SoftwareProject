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
import com.GameForAll.Repository.GameRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Category;
import com.GameForAll.models.Course;
import com.GameForAll.models.Game;
import com.GameForAll.models.Teacher;

@RestController
public class CourseRestController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TeacherRepository teacherRepository;


	
	
	
	/**
	 * @param CategoryName
	 * @return
	 */
	@RequestMapping(value = "/show-courses/{CategoryName}", method = RequestMethod.GET)
	public List<Course> ShowCourse(@PathVariable String CategoryName) {
		Category category = categoryRepository.findByCategoryName(CategoryName);
		List<Course> courses = new ArrayList<>();
		if (category != null) {
			courses = courseRepository.findByCategory(category);
		}
		return courses;
	}

	/**
	 * @param course
	 * @param categoryName
	 * @param username
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addcourse/{categoryName}/{username}")
	public Boolean AddCourse(@RequestBody Course course, @PathVariable String categoryName,
			@PathVariable String username) {
		
		if (course.getCourseName().equals("")) {
			return false;
		}
		Category category = categoryRepository.findByCategoryName(categoryName);
		Teacher teacher = teacherRepository.findByUsername(username);
		Course course2 = courseRepository.findByCourseName(course.getCourseName());
		if (category != null && teacher != null && course2 == null) {
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

	/**
	 * @param courseName
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/GameInCourse/show-Course-games/{courseName}")
	public Set<Game> GetGamesInCourse(@PathVariable String courseName) {
		Course course = courseRepository.findByCourseName(courseName);
		if (course != null) {
			return course.getGames();
		} else {
			return null;
		}
	}

	/**
	 * @param CategoryName
	 * @param username
	 * @return Courses
	 */
	@RequestMapping(value = "/get-courses/{CategoryName}/{username}", method = RequestMethod.GET)
	public List<Course> GetTeacherCourses(@PathVariable String CategoryName, @PathVariable String username) {
		Category category = categoryRepository.findByCategoryName(CategoryName);
		Teacher teacher = teacherRepository.findByUsername(username);
		List<Course> courses = new ArrayList<>();
		if (category != null && teacher != null) {
			courses = courseRepository.findByCategoryAndTeacher(category, teacher);
		}
		return courses;
	}

}
