package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	public Student findByUsername(String username);
	public Student findByEmail(String studentEmail);
	public Student findByPassword(String studentPassword);

}
