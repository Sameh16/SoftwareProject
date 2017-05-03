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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "game")
public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 353170622331771686L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long GameId;

	@Column(name = "gameName", unique = true)
	private String gameName;
	
	@Column(name = "Cancled")
	private boolean cancled;

	@Column(name = "NumberOfLevels")
	private int NumOfLevels;

	@Column(name = "Description")
	private String Description;

	@ManyToOne
	@JoinColumn(name = "TypeId")
	private Type type;

	@ManyToOne
	@JoinColumn(name = "CourseId")
	private Course course;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Comment> comments;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gameQuestion", joinColumns = @JoinColumn(name = "gameId", referencedColumnName = "GameId"), inverseJoinColumns = @JoinColumn(name = "QuestionId", referencedColumnName = "Id"))
	private Set<Question> questions;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<StudentGame> studentGames;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Contributor> contributors;

	public long getGameId() {
		return GameId;
	}

	public void setGameId(long gameId) {
		GameId = gameId;
	}

	public String getgameName() {
		return gameName;
	}

	public void setgameName(String gameName) {
		this.gameName = gameName;
	}

	public int getNumOfLevels() {
		return NumOfLevels;
	}

	public void setNumOfLevels(int numOfLevels) {
		NumOfLevels = numOfLevels;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@JsonIgnore
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public boolean isCancled() {
		return cancled;
	}

	public void setCancled(boolean cancled) {
		this.cancled = cancled;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Contributor> getContributors() {
		return contributors;
	}

	public void setContributors(Set<Contributor> contributors) {
		this.contributors = contributors;
	}

	@JsonIgnore
	public Set<StudentGame> getStudentGames() {
		return studentGames;
	}

	public void setStudentGames(Set<StudentGame> studentGames) {
		this.studentGames = studentGames;
	}

}
