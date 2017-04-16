package com.GameForAll.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answer")
public class Answer{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long AnswerId;
	
	@ManyToOne
	@JoinColumn(name = "QuestionId")
	private Question question;
	
	@Column(name="Answer")
	private String Answer;
	
	@Column(name = "CorrectAnswer")
	private boolean CorrectAnswer;

	public Answer(Question question, String answer, boolean correctAnswer) {
		super();
		this.question = question;
		Answer = answer;
		CorrectAnswer = correctAnswer;
	}

	public Answer() {
		super();
	}

	public long getAnswerId() {
		return AnswerId;
	}

	public void setAnswerId(long answerId) {
		AnswerId = answerId;
	}
	@JsonIgnore
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public boolean isCorrectAnswer() {
		return CorrectAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		CorrectAnswer = correctAnswer;
	}
	
	
	
	
	
	
	
	
}
