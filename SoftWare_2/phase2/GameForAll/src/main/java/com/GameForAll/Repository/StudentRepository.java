package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	Student findByUsername(String username);

}
