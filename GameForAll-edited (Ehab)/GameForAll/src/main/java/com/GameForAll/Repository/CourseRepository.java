package com.GameForAll.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Category;
import com.GameForAll.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	public List<Course> findByCategory(Category Category);
	
}
