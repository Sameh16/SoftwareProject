package com.GameForAll.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "question")
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9056633464889019979L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "Question")
	private String Question;

	@ManyToOne
	@JoinColumn(name = "GameId")
	private Game game;

	@Column(name = "Level")
	private int Level;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Answer> answers;

	public Question() {
		super();
	}

	public Question(String question, Game game, int level, Set<Answer> answers) {
		super();
		Question = question;
		this.game = game;
		Level = level;
		this.answers = answers;
	}

	public long getQuestionId() {
		return Id;
	}

	public void setQuestionId(long questionId) {
		Id = questionId;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public Game getGame() {
		return game;
	}

	@JsonIgnore
	public void setGame(Game game) {
		this.game = game;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

}
