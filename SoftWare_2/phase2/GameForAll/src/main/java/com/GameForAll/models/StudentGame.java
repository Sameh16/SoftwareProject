package com.GameForAll.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "studentgame")
@IdClass(StudentGameID.class)
public class StudentGame implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7905650851903375454L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "StudentId")
	private Student student;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name = "GameId")
	private Game game;
	
	
	
	@Column(name = "Achievement")
	private int achievement;
	
	@Column(name="Comment")
  	private String comment ;
	
	@Column(name =  "Rate")
	private int rate; 
	
	@Column(name = "Level")
	private int	level;

	
	
	@JsonIgnore
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getAchievement() {
		return achievement;
	}

	public void setAchievement(int achievement) {
		this.achievement = achievement;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	
	
	
	

}
