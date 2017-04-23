package com.GameForAll.RestCotrollers;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.GameRepository;

import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.Repository.QuestionRepository;
import com.GameForAll.Repository.StudentGameRepository;
import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TypeRepository;
import com.GameForAll.models.Course;
import com.GameForAll.models.Game;
import com.GameForAll.models.Question;
import com.GameForAll.models.Student;
import com.GameForAll.models.StudentGame;
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
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentGameRepository studentGameRepository;
	
	
	
	 Game game=null;
	 ArrayList<Question> questions=null;
	
	
	@RequestMapping(value= "game/get-type-template/{type}/get-game/{gameID}" ,method=RequestMethod.GET)
	Game GetGame(@PathVariable String type,@PathVariable long gameID)
	{
		 return gameRepository.findOne(gameID); 
		
	}
	
	@RequestMapping(value= "/playgame/{gameID}" ,method=RequestMethod.GET)
	Set<Question>  PlayGame(@PathVariable long gameID)
	{

		 Game game= gameRepository.findOne(gameID);
		 if (game != null )
		 {
			 this.game=game;
			 this.questions= new ArrayList<Question>( game.getQuestions());
			 this.questions.sort(new Comparator<Question>() {

				@Override
				public int compare(Question q1, Question q2) {
					
					return q1.getLevel()-q2.getLevel();
				}
				 
			});
			 return  game.getQuestions();
		 }
	
		 return null;
		
	}

	@RequestMapping(value= "/playgame/{gameID}/{questionIndex}" ,method=RequestMethod.GET)
	Question  getQuestion(@PathVariable long gameID,@PathVariable long questionIndex)
	{
		

		if (game== null)
		{
			 game= gameRepository.findOne(gameID);
			 this.questions= new ArrayList<Question>( game.getQuestions());
			 this.questions.sort(new Comparator<Question>() {

					@Override
					public int compare(Question q1, Question q2) {
						
						return q1.getLevel()-q2.getLevel();
					}
					 
				});
		}
		if (game != null )
		 {
	
			
			 if (questionIndex>questions.size())
			 {
				 return null;
			 }

			 return questions.get((int) questionIndex-1);
		 }
		 return null;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/SaveStudentGame/{GameID}/{StudentID}")
	public boolean SaveGame(@RequestBody StudentGame  studentGame, @PathVariable long GameID, @PathVariable long StudentID) 
	{
		
		
		Student student = studentRepository.findOne(StudentID);
		Game game= gameRepository.findOne(GameID);
		if (game != null && student != null ) {
			studentGame.setStudent(student);
			studentGame.setGame(game);
		System.out.println("3456789078676543");

			studentGameRepository.save(studentGame);
			System.out.println("saaaaaaaaaaaaaaaaave");

			return true;
		}
		return false;
			
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/create-game/{courseID}/{typeID}/{teacherID}")
	public long CreateGame(@RequestBody Game game, @PathVariable long courseID, @PathVariable long typeID,@PathVariable long teacherID) 
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
		}
		return game.getGameId();
			
	}
	
	
}
