package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
}
