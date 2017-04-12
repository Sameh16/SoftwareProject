package com.GameForAll.RestCotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Student;
import com.GameForAll.models.Teacher;

@Controller
public class TeacherController {
	
	private Student student;
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public boolean verification(Teacher teacher) 
	{
		if(studentRepository.FindByEmail(student.getEmail())!=null || teacherRepository.FindByEmail(student.getEmail())!=null || teacherRepository.FindByUserName(teacher.getUsername())!=null || studentRepository.FindByUserName(student.getUsername())!=null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/teacher/add-teacher")
	public boolean SignUp(@RequestBody Teacher teacher) 
	{
		if(verification(teacher)==true)
		{
			teacherRepository.save(teacher);
			return true;
			//System.out.println("Great! Welcome "+ teacher.getName());
		}
		else
		{
			return false;
			//System.out.println("Enter valid Email or Password!!");
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/teacher/signin")
	public boolean SignIn(@RequestBody String teacherUserName,String teacherPassword)
	{
		if(teacherRepository.FindByUserName(teacherUserName)!=null && teacherRepository.FindByPassword(teacherPassword)!= null)
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
