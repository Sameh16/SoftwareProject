package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	public Teacher FindByEmail(String teacherEmail);
	public Teacher FindByUserName(String teacherUserName);
	public Teacher FindByPassword(String teacherPassword);

}
