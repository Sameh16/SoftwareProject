package com.GameForAll.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Teacher;

public class TeacherServices {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public Teacher FindTeacher(long teacherId)
	{
		return teacherRepository.findOne(teacherId);
	}
}
