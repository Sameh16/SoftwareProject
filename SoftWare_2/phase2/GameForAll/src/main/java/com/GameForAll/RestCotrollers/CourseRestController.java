package com.GameForAll.RestCotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.models.Category;
import com.GameForAll.models.Course;
import com.GameForAll.models.Teacher;
import com.GameForAll.services.CategoryServices;
import com.GameForAll.services.CourseServices;
import com.GameForAll.services.TeacherServices;

@RestController
public class CourseRestController {

	@Autowired
	private CourseServices courseServices;
	private CategoryServices categoryServices;
	private TeacherServices teacherServices;

	@RequestMapping(value = "/showcourse/{CategoryId}", method = RequestMethod.GET)
	public List<Course> ShowCourse(@PathVariable int CategoryId) {
		return courseServices.GetAllCourses(CategoryId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcourse/{categoryId}/{teacherId}")
	public void AddCourse(@RequestBody Course c, @PathVariable int categoryId, @PathVariable int teacherId) {
		/* Verification step */
		c.setCategory(new Category(categoryId, ""));
		c.setTeacher(new Teacher(teacherId, "", "", 0, "", "", ""));
		if (categoryServices.FindCatgeory(categoryId) != null && teacherServices.FindTeacher(teacherId) != null) {
			courseServices.addCourse(c);
		} else {
			System.out.println("Not Valid CategoryId or TeacherId!!");
		}
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST, value =
	 * "/addcourse/{TeacherId}/{CategoryId}") public Boolean
	 * AddCourse(@RequestBody Course course,@PathVariable long
	 * TeacherId,@PathVariable long CategoryId) { /* Vrefication
	 */
	/*
	 * System.out.println(course.toString()); Teacher teacher =
	 * TeacherRepo.findOne(TeacherId); Category category =
	 * CategoryRepo.findOne(CategoryId); if(teacher!=null && category!=null) {
	 * course.setCategory(category); course.setTeacher(teacher);
	 * if(CourseRepo.save(course) != null) { return true; } }
	 * 
	 * return false;
	 * 
	 * }
	 */}
