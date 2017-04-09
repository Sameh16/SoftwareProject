package com.GameForAll.RestCotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Student;
import com.GameForAll.models.Teacher;


@RestController
public class UserRestController {
	
	@Autowired
	StudentRepository StudentRepo;
	
	@Autowired
	TeacherRepository TeacherRepo;

	@RequestMapping(method = RequestMethod.POST, value = "/add-student")
	public boolean verification(@RequestBody Student student) {
		/*
		 * if(t.teachers.contains(user)) { return false; } else { return true; }
		 */
		if(StudentRepo.save(student)!=null)
			return true;
		return false;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add-teacher")
	public boolean SignUp(@RequestBody Teacher teacher) {
		/*
		 * if(t.teachers.contains(user)) { return false; } else { return true; }
		 */
		if(TeacherRepo.save(teacher)!=null)
			return true;
		return false;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public boolean SignIn(@RequestBody String userName,String Password) {
		/*
		 * if(t.SearchUser(user)==false) { return false; } else { return true; }
		 */
		
		return true;
	}

}
