package com.GameForAll.RestCotrollers;

import java.sql.Timestamp;
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

import com.GameForAll.Repository.AnswerRepository;
import com.GameForAll.Repository.CommentRepository;
import com.GameForAll.Repository.ContributorRepository;
import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.GameRepository;
import com.GameForAll.Repository.NotificationRepository;
import com.GameForAll.Repository.TeacherRepository;
import com.GameForAll.Repository.QuestionRepository;
import com.GameForAll.Repository.StudentGameRepository;
import com.GameForAll.Repository.StudentRepository;
import com.GameForAll.Repository.TypeRepository;
import com.GameForAll.models.Answer;
import com.GameForAll.models.Comment;
import com.GameForAll.models.Contributor;
import com.GameForAll.models.Course;
import com.GameForAll.models.Game;
import com.GameForAll.models.Notification;
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
	AnswerRepository answerRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentGameRepository studentGameRepository;

	@Autowired
	ContributorRepository contributorRepository; // add
	
	@Autowired
	CommentRepository commentRepository;

	@Autowired
	NotificationRepository notificationRepository;

	@RequestMapping(value = "/get-game/{name}", method = RequestMethod.GET)
	public List<Game> GetGame(@PathVariable String name) {
		List<Game> games = new ArrayList<>();
		games = gameRepository.findBygameNameStartingWith(name);
		for(int i=0;i<games.size();i++){
			if(games.get(i).getGameId()!=games.get(i).getNewId()){
				games.remove(games.get(i));
				i--;
			}
		}
		return games;
	}



	@RequestMapping(method = RequestMethod.GET,value = "/copygame/{GameName}/{NewGameName}/{TeacherName}/{CourseName}")
	public boolean CopyGame(@PathVariable String GameName, @PathVariable String NewGameName,@PathVariable String TeacherName,@PathVariable String CourseName) {
		
		List<Game> OldGames=gameRepository.findBygameName(GameName);
		Course course=courseRepository.findByCourseName(CourseName);
		Teacher teacher=teacherRepository.findByUsername(TeacherName);
		Contributor contributor=new Contributor();
		
		if(course!=null && teacher !=null && OldGames!=null){
			Game NewGame=new Game();
			NewGame.setgameName(NewGameName);
			NewGame.setCourse(course);
			
			
			Game OldGame=new Game();
		
			for(int i=0;i<OldGames.size();i++){
				if(OldGames.get(i).getGameId()==OldGames.get(i).getNewId()){
					OldGame=OldGames.get(i);
				}
			}
			
			NewGame.setDescription(OldGame.getDescription());
			
			NewGame.setNumOfLevels(OldGame.getNumOfLevels());
			
			NewGame.setType(OldGame.getType());
			
			NewGame.setCancled(false);
			
			gameRepository.save(NewGame);
			NewGame.setNewId(NewGame.getGameId());
			gameRepository.save(NewGame);
			course.getGames().add(NewGame);		
			contributor.setGame(NewGame);
			contributor.setTeacher(teacher);
			contributorRepository.save(contributor);
			
			List<Question> OldGameQuestions=questionRepository.findBygame(OldGame);
			
			for(int i=0;i<OldGameQuestions.size();i++){
				Question NewGameQuestion=new Question();
				
				NewGameQuestion.setQuestion(OldGameQuestions.get(i).getQuestion());
				NewGameQuestion.setLevel(OldGameQuestions.get(i).getLevel());
				NewGameQuestion.setGames(NewGame);
				questionRepository.save(NewGameQuestion);
				//NewGame.getQuestions().add(NewGameQuestion);
				
				
				
				
				List<Answer> OldGameAnswers=answerRepository.findByquestion(OldGameQuestions.get(i));
				for(int j=0;j<OldGameAnswers.size();j++){
					Answer NewGameAnswer=new Answer();
					
					NewGameAnswer.setAnswer(OldGameAnswers.get(j).getAnswer());
					NewGameAnswer.setCorrectAnswer(OldGameAnswers.get(j).isCorrectAnswer());
					NewGameAnswer.setQuestion(NewGameQuestion);
					
					answerRepository.save(NewGameAnswer);
					
					//NewGameQuestion.getAnswers().add(NewGameAnswer);
				}
			}
	
					
			
			
				
		}
		return true;	
	}


	

	@RequestMapping(value = "/course/show-games-specific-course/{CourseId}", method = RequestMethod.GET)
	Set<Game> ShowGamesSpecificCourse(@PathVariable long CourseId) {
		Course course = courseRepository.findOne(CourseId);
		Set<Game> games = null;
		if (course != null) {
			games = (Set<Game>) course.getGames();
		}
		return games;

	}

	/**
	 * @param type
	 * @param gameID
	 * @return
	 */
	@RequestMapping(value = "game/get-type-template/{type}/get-game/{gameID}", method = RequestMethod.GET)
	Game GetGame(@PathVariable String type, @PathVariable long gameID) {
		return gameRepository.findOne(gameID);

	}

	/**
	 * @param gameID
	 * @return
	 */
	
	
	
	

	/**
	 * @param gameID
	 * @param questionIndex
	 * @return
	 */
	
	@RequestMapping(value = "/playgame/{gameID}/{questionIndex}", method = RequestMethod.GET)
	Question getQuestion(@PathVariable long gameID, @PathVariable long questionIndex) {
			Game game = null;
			ArrayList<Question> questions = null;
			game = gameRepository.findOne(gameID);
			questions = new ArrayList<Question>(game.getQuestions());
			questions.sort(new Comparator<Question>() {

				@Override
				public int compare(Question q1, Question q2) {

					return q1.getLevel() - q2.getLevel();
				}
			});
			if (questionIndex > questions.size()) {
				return null;
			}
			return questions.get((int) questionIndex - 1);
	}
	
	@RequestMapping(value = "/verify-game-name/{GameName}", method = RequestMethod.GET)
	boolean VerifyGameName(@PathVariable String GameName) {
		List<Game>games=gameRepository.findBygameName(GameName);
		if(games.size()!=0){
			return false;
		}
		return true;
	}
	

	/**
	 * @param studentGame
	 * @param GameID
	 * @param Username
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/SaveStudentGame/{GameID}/{Username}")
	public boolean SaveGame(@RequestBody StudentGame studentGame, @PathVariable long GameID,
			@PathVariable String Username) {
		Student student = studentRepository.findByUsername(Username);
		Game game = gameRepository.findOne(GameID);
		if (game != null && student != null) {
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
	@RequestMapping(method = RequestMethod.POST, value = "/create-game/{courseName}/{typeID}/{username}")
	public long CreateGame(@RequestBody Game game, @PathVariable String courseName, @PathVariable long typeID,
			@PathVariable String username) {
		
		Course course = courseRepository.findByCourseName(courseName);
		Type type = typeRepository.findOne(typeID);
		Teacher teacher = teacherRepository.findByUsername(username);
		if (course != null && type != null && teacher != null) {
			game.setCourse(course);
			game.setType(type);
			Contributor contributor = new Contributor();// add
			contributor.setGame(game);// add
			contributor.setTeacher(teacher);// add
			// game.setTeacher(teacher);
			course.getGames().add(game);
			type.getGames().add(game);
			// teacher.getGames().add(game);
			gameRepository.save(game);
			contributorRepository.save(contributor);// add

			game.setNewId(game.getGameId());
			gameRepository.save(game);

			addNotification(course, game, teacher);

		}
		return game.getGameId();

	}

	@RequestMapping(value = "/WriteComment/{gameID}/{username}", method = RequestMethod.POST)
	public boolean SaveComment(@RequestBody Comment comment, @PathVariable long gameID, @PathVariable String username) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		Game game = new Game();
		game = gameRepository.findOne(gameID);
		if (game == null)
			return false;
		comment.setDate(timestamp);
		comment.setGame(game);
		comment.setUsername(username);
		comment.setSeen(false);
		commentRepository.save(comment);
		return true;
	}

	@RequestMapping(value = "/GetComments/{username}", method = RequestMethod.GET)
	public ArrayList<Comment> GetComments(@PathVariable String username) {
		ArrayList<Comment> comments = new ArrayList<>();// new HashSet<>();
		ArrayList<Game> Games = new ArrayList<>();
		Teacher teacher = teacherRepository.findByUsername(username);

		if (teacher == null)
			return null;

		ArrayList<Contributor> Cont = new ArrayList<>(teacher.getContributors());
		for (int i = 0; i < Cont.size(); i++) {
			Games.add(Cont.get(i).getGame());
		}

		for (int i = 0; i < Games.size(); i++) {
			ArrayList<Comment> tempcomments = new ArrayList<>();
			tempcomments.addAll(Games.get(i).getComments());
			for (Comment comment : tempcomments) {
				comments.add(comment);
				comment.setSeen(true);
				commentRepository.save(comment);

			}

		}

		comments.sort(new Comparator<Comment>() {

			@Override
			public int compare(Comment comment1, Comment comment2) {
				return comment1.getDate().compareTo(comment1.getDate());
			}

		});

		return comments;

	}

	private void addNotification(Course course, Game game, Teacher teacher) {
		for (Student student : course.getStudents()) {
			Notification temp = new Notification();
			temp.setCourseName(course.getCourseName());
			temp.setGameName(game.getgameName());
			temp.setStudent(student);
			temp.setTeacherName(teacher.getName());
			notificationRepository.save(temp);
			student.getNotifications().add(temp);
			studentRepository.save(student);
		}
	}
}

