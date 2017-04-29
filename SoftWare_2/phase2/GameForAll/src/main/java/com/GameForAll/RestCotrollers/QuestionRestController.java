package com.GameForAll.RestCotrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.GameRepository;
import com.GameForAll.Repository.QuestionRepository;
import com.GameForAll.Repository.TypeRepository;
import com.GameForAll.models.Game;
import com.GameForAll.models.Question;
import com.GameForAll.models.Type;


@RestController
public class QuestionRestController {
	
	
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/game/get-question", method = RequestMethod.GET)
	public List<Type> GetAllTypes() {
		
		return (List<Type>) typeRepository.findAll();
	}
	
	/**
	 * @param question
	 * @param GameID
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value ="/create-question/{GameID}")
	public long AddQuestion(@RequestBody Question question,@PathVariable long GameID) 
	{
		
		Game game= gameRepository.findOne(GameID);
		if (game!=null) {
			question.setGame(game);
			questionRepository.save(question);
			game.getQuestions().add(question);
		}
		return question.getQuestionId();
			
	}
}
