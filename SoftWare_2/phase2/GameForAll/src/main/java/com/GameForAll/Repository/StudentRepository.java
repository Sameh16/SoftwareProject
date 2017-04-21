package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Student;
import com.GameForAll.models.Teacher;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	public Student findByUsername(String username);
	public Student findByEmail(String studentEmail);
	public Student findByPassword(String studentPassword);
	public Student findByUsernameAndPassword(String username,String studentPassword);
}
