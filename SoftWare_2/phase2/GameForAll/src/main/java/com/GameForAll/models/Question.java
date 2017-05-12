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
	@JoinColumn(name = "gameId")
	private Game game;

	@Column(name = "Level")
	private int Level;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Answer> answers;

	public Question() {
		super();
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

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Game getGames() {
		return game;
	}

	public void setGames(Game game) {
		this.game = game;
	}



}
