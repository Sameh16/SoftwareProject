package com.GameForAll.RestCotrollers;

import java.util.ArrayList;
import java.util.List;

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
	private CourseRepository courseRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@RequestMapping(value = "/course/show-courses/{CategoryId}", method = RequestMethod.GET)
	public List<Course> ShowCourse(@PathVariable long CategoryId) {
		Category category = categoryRepository.findOne(CategoryId);
		List<Course> categories = new ArrayList<>();
		if(category!=null)
		{
			 categories=  courseRepository.findByCategory(category);
		}
		return categories;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/course/addcourse/{categoryId}/{teacherId}")
	public boolean AddCourse(@RequestBody Course course, @PathVariable long categoryId, @PathVariable long teacherId) {
		/* Verification step */
		Category category = categoryRepository.findOne(categoryId);
		Teacher teacher = teacherRepository.findOne(teacherId);

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

}
