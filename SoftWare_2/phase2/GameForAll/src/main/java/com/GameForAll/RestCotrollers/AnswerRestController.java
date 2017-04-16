package com.GameForAll.RestCotrollers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.AnswerRepository;

import com.GameForAll.Repository.QuestionRepository;

import com.GameForAll.models.Answer;

import com.GameForAll.models.Question;



@RestController
public class AnswerRestController {
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping(method = RequestMethod.POST, value ="/create-answer/{QID}")
	public void AddQuestion(@RequestBody Answer answer,@PathVariable long QID) 
	{
		Question question= questionRepository.findOne(QID);
		if (question!=null) {
			answer.setQuestion(question);
			answerRepository.save(answer);
			question.getAnswers().add(answer);
		}
		
			
	}
}
