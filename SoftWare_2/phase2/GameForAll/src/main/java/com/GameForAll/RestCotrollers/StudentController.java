package com.GameForAll.RestCotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Student;
import com.GameForAll.models.Teacher;

public class StudentController {

	private Teacher teacher;
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TeacherRepository teacherRepository;

	public boolean verification(Student student) 
	{
		if(studentRepository.FindByEmail(student.getEmail())!=null || teacherRepository.FindByEmail(student.getEmail())!=null || teacherRepository.FindByUserName(teacher.getUsername())!=null || studentRepository.FindByUserName(student.getUsername())!=null)
		{
			return false;
		}
		else
		{
			studentRepository.save(student);
			return true;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/student/add-student")
	public boolean SignUp(@RequestBody Student student) 
	{
		if(verification(student)==true)
		{
			studentRepository.save(student);
			return true;
			//System.out.println("Great! Welcome"+ student.getName());
		}
		else
		{
			return false;
			//System.out.println("Enter valid Email or Password!!");
		}
	}
	@RequestMapping(method = RequestMethod.POST, value = "/student/signin")
	public boolean SignIn(@RequestBody String studentUserName,String studentPassword)
	{
		if(studentRepository.FindByUserName(studentUserName)!=null && teacherRepository.FindByPassword(studentPassword)!= null)
		{
			return true;
			//System.out.println("Welcome back!");
		}
		else
		{
			return false;
			//System.out.println("Invalid UserName or Password!");
		}
	}


}
