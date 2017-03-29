package com.GameForAll.models;

import java.util.ArrayList;

public class Question {
	
	private String Question;
	private int coorrectIndex;
	private int Level;
	private int GameId;
	private ArrayList<String>Answers;
	
	
	
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public int getGameId() {
		return GameId;
	}
	public void setGameId(int gameId) {
		GameId = gameId;
	}
	public ArrayList<String> getAnswers() {
		return Answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		Answers = answers;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public int getCoorrectIndex() {
		return coorrectIndex;
	}
	public void setCoorrectIndex(int coorrectIndex) {
		this.coorrectIndex = coorrectIndex;
	}
	
	
	

}
