package com.GameForAll.RestCotrollers;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.ContributorRepository;
import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.GameRepository;

import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.Repository.QuestionRepository;
import com.GameForAll.Repository.StudentGameRepository;
import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TypeRepository;
import com.GameForAll.models.Contributor;
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
	
	@Autowired
	ContributorRepository contributorRepository; // add
	
	
	@RequestMapping(value = "/get-game/{name}", method = RequestMethod.GET)
	public List<Game> GetGame(@PathVariable String name) {
		List<Game> games = new ArrayList<>();
		games=gameRepository.findBygameNameStartingWith(name);
		return games;
	}
	
	/*
	@RequestMapping(method = RequestMethod.GET,value = "/copygame/{GameName}/{NewGameName}/{TeacherName}/{CourseName}")
	public boolean CopyGame(@PathVariable String GameName, @PathVariable String NewGameName,@PathVariable String TeacherName,@PathVariable String CourseName) {
		Game OldGame=(Game) gameRepository.findBygameName(GameName);
		Course course=courseRepository.findByCourseName(CourseName);
		Contributor teacher=cont.findByUsername(TeacherName);
		if(course!=null && teacher !=null && OldGame!=null){
			Game NewGame=OldGame;
			NewGame.setgameName(NewGameName);
			NewGame.setCourse(course);
			NewGame.setContributors(teacher);
			gameRepository.save(NewGame);
			course.getGames().add(NewGame);
		}
		return true;	
	}
	*/
	
	
	
	
	 Game game=null;
	 ArrayList<Question> questions=null;
	
	 @RequestMapping(value= "/course/show-games-specific-course/{CourseId}",method=RequestMethod.GET)
		Set<Game> ShowGamesSpecificCourse(@PathVariable long CourseId)
		{
			Course course=courseRepository.findOne(CourseId);
			Set<Game> games = null;
			if (course!= null){
				games= (Set<Game>) course.getGames();
			}
			return games;
			
		}
	
	/**
	 * @param type
	 * @param gameID
	 * @return
	 */
	@RequestMapping(value= "game/get-type-template/{type}/get-game/{gameID}" ,method=RequestMethod.GET)
	Game GetGame(@PathVariable String type,@PathVariable long gameID)
	{
		 return gameRepository.findOne(gameID); 
		
	}
	
	/**
	 * @param gameID
	 * @return
	 */
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

	/**
	 * @param gameID
	 * @param questionIndex
	 * @return
	 */
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
	
	
	
	/**
	 * @param studentGame
	 * @param GameID
	 * @param Username
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/SaveStudentGame/{GameID}/{Username}")
	public boolean SaveGame(@RequestBody StudentGame  studentGame, @PathVariable long GameID, @PathVariable String Username) 
	{
		Student student = studentRepository.findByUsername(Username);
		Game game= gameRepository.findOne(GameID);
		if (game != null && student != null ) {
			studentGame.setStudent(student);
			studentGame.setGame(game);
			studentGameRepository.save(studentGame);
			return true;
		}
		return false;	
	}
	
	
	/**
	 * @param game
	 * @param courseID
	 * @param typeID
	 * @param username
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/game/create-game/{courseID}/{typeID}/{username}")
	public long CreateGame(@RequestBody Game game, @PathVariable long courseID, @PathVariable long typeID,@PathVariable String username) 
	{
		Course course = courseRepository.findOne(courseID);
		Type type = typeRepository.findOne(typeID);
		Teacher teacher = teacherRepository.findByUsername(username);
		if (course != null && type != null && teacher!=null) {
			game.setCourse(course);
			game.setType(type);
			Contributor contributor = new Contributor();// add
			contributor.setGame(game);// add
			contributor.setTeacher(teacher);// add
			//game.setTeacher(teacher);
			course.getGames().add(game);
			type.getGames().add(game);
			//teacher.getGames().add(game);
			gameRepository.save(game);
			contributorRepository.save(contributor);// add
		}
		return game.getGameId();
			
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/add-collaborators/teacher")
	public long addCollaborators(@RequestBody Game game,@RequestBody Contributor teacher) 
	{
		List<Contributor> contributors=new ArrayList<>();
		contributors.add(teacher);
		game.setContributors((Set<Contributor>)contributors);
		return contributors.get(contributors.size()-1).getTeacher().getId();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/cancel-game/{username}")
	public boolean cancelGame(@RequestBody Game game,@PathVariable String username) 
	{
		Contributor teacher=contributorRepository.findByTeacherUsername(username);
		List<Contributor> contributors=(List<Contributor>) game.getContributors();
		if(contributors.contains(teacher))
		{
			teacher.getGame().setCancled(true);	
		}
		boolean cancel=false;
		Contributor contributor=new Contributor();
		for(int i=0;i<contributors.size();i++)
		{
			contributor=contributors.get(i);
			if(!contributor.getGame().isCancled())
			{
				cancel=false;
				break;
			}
			else
			{
				cancel=true;
			}
		}
		if(cancel==true)
		{
			gameRepository.delete(game);
			return true;
		}
		return false;
	}
	
	
}
