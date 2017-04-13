package com.GameForAll.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Category;
import com.GameForAll.models.Course;
import com.GameForAll.models.Teacher;

public interface CourseRepository extends CrudRepository<Course, Long> {

	public List<Course> findByCategory(Category Category);
<<<<<<< HEAD
	public List<Course> findByCategoryAndTeacher(Category category,Teacher teacher);
=======
	public Course findByCourseName(String courseName);
>>>>>>> 6aaf531604104fe81768f89754c968f7245c6491
	
}
