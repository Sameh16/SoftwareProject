package com.GameForAll.RestCotrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.GameRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.Repository.TypeRepository;
import com.GameForAll.models.Category;
import com.GameForAll.models.Course;
import com.GameForAll.models.Game;
import com.GameForAll.models.Teacher;
import com.GameForAll.models.Type;


@RestController
public class GameRestController {
	
	@Autowired
	GameRepository gameRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	TeacherRepository teacherRepository;
	
	@RequestMapping("/palygame")
	void PlayGame()
	{
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/create-game/{courseID}/{typeID}/{teacherID}")
	public boolean CreateGame(@RequestBody Game game, @PathVariable long courseID, @PathVariable long typeID,@PathVariable long teacherID) 
	{
		Course course = courseRepository.findOne(courseID);
		Type type = typeRepository.findOne(typeID);
		Teacher teacher = teacherRepository.findOne(teacherID);
		if (course != null && type != null && teacher!=null) {
			game.setCourse(course);
			game.setType(type);
			game.setTeacher(teacher);
			course.getGames().add(game);
			type.getGames().add(game);
			teacher.getGames().add(game);
			gameRepository.save(game);
			return true;
		}
			return false;
	}
	
	
}
