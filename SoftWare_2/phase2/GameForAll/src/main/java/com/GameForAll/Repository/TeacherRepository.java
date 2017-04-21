package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	public Teacher findByAcadmicMail(String teacherEmail);
	public Teacher findByUsername(String teacherUserName);
	public Teacher findByPassword(String teacherPassword);
	public Teacher findByUsernameAndPassword(String teacherUserName,String teacherPassword);

}
