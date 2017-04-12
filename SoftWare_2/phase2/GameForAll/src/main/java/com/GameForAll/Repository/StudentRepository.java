package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	public Student FindByEmail(String studentEmail);
	public Student FindByUserName(String studentUserName);
	public Student FindByPassword(String studentPassword);

}
