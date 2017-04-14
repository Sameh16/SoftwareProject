package com.GameForAll.RestCotrollers;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.GameRepository;
import com.GameForAll.Repository.QuestionRepository;
import com.GameForAll.Repository.TypeRepository;
import com.GameForAll.models.Course;
import com.GameForAll.models.Game;
import com.GameForAll.models.Question;
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
	QuestionRepository questionRepository;
	
	
	
	
	@RequestMapping(value= "/playgame/{gameID}" ,method=RequestMethod.GET)
	Set<Question>  PlayGame(@PathVariable long gameID)
	{
		 Game game= gameRepository.findOne(gameID);
		 if (game != null )
		 {
			 return  game.getQuestions();
		 }
	
		 return null;
		
	}

	@RequestMapping(value= "/playgame/{gameID}/{quesionIndex}" ,method=RequestMethod.GET)
	Question  getQuestion(@PathVariable long gameID,@PathVariable long quesionIndex)
	{
		
		 Game game= gameRepository.findOne(gameID);
		 if (game != null )
		 {
			 
			 Set<Question> q= game.getQuestions();
			 Question question = null;
			 while (quesionIndex--<0)
				 {
				 question=  q.iterator().next();
				 }
			 return question;
		 }
		 return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/create-game/{courseID}/{typeID}")
	public boolean CreateGame(@RequestBody Game game, @PathVariable long courseID, @PathVariable long typeID) 
	{
		Course course = courseRepository.findOne(courseID);
		Type type = typeRepository.findOne(typeID);
		if (course != null && type != null) {
			game.setCourse(course);
			game.setType(type);
			course.getGames().add(game);
			type.getGames().add(game);
			gameRepository.save(game);
			return true;
		}
			return false;
	}
	
	
}
