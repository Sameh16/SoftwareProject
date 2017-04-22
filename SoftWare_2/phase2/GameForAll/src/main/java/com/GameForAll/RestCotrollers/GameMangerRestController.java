package com.GameForAll.RestCotrollers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.GameRepository;
import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Game;
import com.GameForAll.models.Student;
import com.GameForAll.models.StudentGame;
import com.GameForAll.models.Teacher;

@RestController
public class GameMangerRestController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@RequestMapping(value="/get-student-games-score/{username}")
	public Set<StudentGame> getStudentGamesScore(@PathVariable String username)
	{
		Student student = studentRepository.findByUsername(username);
		
		if(student!=null)
		{
			return student.getStudentGames();
		}
		return null;
		
	}
	
	@RequestMapping(value="/get-teacher-games/{username}")
	public Set<Game> getTeacherGames(@PathVariable String username)
	{
		Teacher teacher = teacherRepository.findByUsername(username);
		
		if(teacher!=null)
		{
			return teacher.getGames();
		}
		return null;
		
	}
	
}