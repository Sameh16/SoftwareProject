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
import com.GameForAll.models.User;

@RestController
public class UserRestController {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StudentRepository studentRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/add-student")
	public boolean StudentSiginUp(@RequestBody Student student) {
		if (verification(student)) {
			
			studentRepository.save(student);
			return true;

		} else {
			return false;
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/add-teacher")
	public boolean TeacherSignUp(@RequestBody Teacher teacher) {
		if (verification(teacher) == true) {
			teacherRepository.save(teacher);
			return true;

		} else {
			return false;
		}

	}

	private boolean verification(User user) {
		
		Class<? extends User> s = user.getClass();
		User user1 = null;
		User user2 = null;
		User user3 = null;
		User user4 = null;
		if (s.getSimpleName().equals("Student")) {
			Student student = (Student) user;
			user1 = studentRepository.findByEmail(student.getEmail());
			user2 = teacherRepository.findByAcadmicMail(student.getEmail());
			user3 = teacherRepository.findByUsername(student.getUsername());
			user4 = studentRepository.findByUsername(student.getUsername());

		} else {
			Teacher teacher = (Teacher) user;
			user1 = studentRepository.findByEmail(teacher.getAcadmicMail());
			user2 = teacherRepository.findByAcadmicMail(teacher.getAcadmicMail());
			user3 = teacherRepository.findByUsername(teacher.getUsername());
			user4 = studentRepository.findByUsername(teacher.getUsername());

		}

		if (user1 != null || user2 != null || user3 != null || user4 != null) {
			return false;
		} else {
			return true;
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/user-login")
	public long SignIn(@RequestBody Student s) {
		Teacher teacher = teacherRepository.findByUsernameAndPassword(s.getUsername(), s.getPassword());
		Student student = studentRepository.findByUsernameAndPassword(s.getUsername(), s.getPassword());
		
		if (teacher != null) {
			return teacher.getId();
		} 
		else if (student != null ) {
			return student.getId();
		} 
		else{
			return 0;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/get-user-type")
	public String type(@RequestBody User user)
	{
		Class<? extends User> s = user.getClass();
		System.out.println(s.getSimpleName());
		if(s.getSimpleName().equals("Student"))
		{
			return "Student";
		}
		else
		{
			return "Teacher";
		}
	}
	
	
}
