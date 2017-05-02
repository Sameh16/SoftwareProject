package com.GameForAll.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contributor")
@IdClass(ContributorID.class)
public class Contributor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5830986126147417424L;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name = "TeacherId")
	private Teacher teacher;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name = "GameId")
	private Game game;


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}	
	
	
	
	
}
