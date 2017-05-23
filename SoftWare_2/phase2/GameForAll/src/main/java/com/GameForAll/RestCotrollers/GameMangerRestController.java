package com.GameForAll.RestCotrollers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.ContributorRepository;
import com.GameForAll.Repository.GameRepository;
import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.models.Contributor;
import com.GameForAll.models.Game;
import com.GameForAll.models.Student;
import com.GameForAll.models.StudentGame;
import com.GameForAll.models.Teacher;
import com.GameForAll.models.Notification;

@RestController
public class GameMangerRestController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	ContributorRepository contributorRepository;
	
	/**
	 * @param username
	 * @return
	 */
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
	
	/**
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/get-teacher-games/{username}")
	public Set<Game> getTeacherGames(@PathVariable String username)
	{
		Teacher teacher = teacherRepository.findByUsername(username);
		
		if(teacher!=null)
		{
			Set<Game> Games = new HashSet<>();
			for (Contributor contributor : teacher.getContributors()) {
				Games.add(contributor.getGame());
			}
			return Games;
		}
		return null;
		
	}
	
	
	@RequestMapping(value = "/get-student-notification/{username}")
	public Set<Notification> getStudentComments(@PathVariable String username)
	{
		Set<Notification> notifications = null ;
		Student student = studentRepository.findByUsername(username);
		if(student!=null)
		{
			notifications = student.getNotifications();
		}
		return notifications;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/add-collaborators/teacher/{username}/gameId}")
	public boolean addCollaborators(@PathVariable long gameId,@PathVariable String username) 
	{
		Teacher teacher = teacherRepository.findByUsername(username);
		Game game = gameRepository.findOne(gameId);
		if(game != null && teacher != null)
		{
			Contributor contributor = new Contributor();
			contributor.setTeacher(teacher);
			contributor.setGame(game);
			Set<Contributor> contributors=game.getContributors();
			contributors.add(contributor);
			contributors=teacher.getContributors();
			contributors.add(contributor);
			contributorRepository.save(contributor);
			teacherRepository.save(teacher);
			gameRepository.save(game);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/cancel-game/{username}/{gameId}")
	public boolean cancelGame(@PathVariable long gameId,@PathVariable String username) 
	{
		Teacher teacher =teacherRepository.findByUsername(username);
		Game game= gameRepository.findOne(gameId);
		if(game!=null && teacher!=null)
		{
			Contributor contributor = contributorRepository.findByGameAndTeacher(game, teacher);
			contributor.getGame().setCancled(true);
		    contributorRepository.save(contributor);
			teacherRepository.save(teacher);
			gameRepository.save(game);
		      return true;
			
		}	
		return false;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/uncancel-game/{username}/{gameId}")
	public boolean unCancelGame(@PathVariable long gameId,@PathVariable String username) 
	{
		Teacher teacher =teacherRepository.findByUsername(username);
		Game game= gameRepository.findOne(gameId);
		if(game!=null && teacher!=null)
		{
			Contributor contributor = contributorRepository.findByGameAndTeacher(game, teacher);
			contributor.getGame().setCancled(false);
		    contributorRepository.save(contributor);
			teacherRepository.save(teacher);
			gameRepository.save(game);
		      return true;
			
		}
		return false;
	}
	
	
	
}
