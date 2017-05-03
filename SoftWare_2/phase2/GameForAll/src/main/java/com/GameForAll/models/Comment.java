package com.GameForAll.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3213741100359949675L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commentId;

	@Column(name = "comment")
	private String comment;

	@Column(name = "username")
	private String username;

	@ManyToOne
	@JoinColumn(name = "gameId")
	private Game game;

	public Comment() {

	}

	public Comment(String comment, String username, Game game) {
		this.comment = comment;
		this.username = username;
		this.game = game;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
