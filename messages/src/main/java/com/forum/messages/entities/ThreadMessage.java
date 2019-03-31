package com.forum.messages.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="thread_messages")
public class ThreadMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="thread_message_id")
	private int Id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	@NotNull
	@Column(name="message")
	private String text;
	
	@NotNull
	@Column(name="date")
	private Timestamp date;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="thread_id")
	private ForumThread forumThread;
	
	@NotNull
	@Column(name="edited")
	private int edited;
	
	@Column(name="date_edited")
	private Timestamp date_edited;

	public ThreadMessage() {}
	
	public ThreadMessage(User user, String text, ForumThread forumThread) {
		this.user = user;
		this.text = text;
		this.forumThread = forumThread;
		this.date =  new Timestamp(System.currentTimeMillis());
		this.edited = 0;
		this.date_edited = null;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public ForumThread getForumThread() {
		return forumThread;
	}

	public void setForumThread(ForumThread forumThread) {
		this.forumThread = forumThread;
	}

	public int getEdited() {
		return edited;
	}

	public void setEdited(int edited) {
		this.edited = edited;
	}

	public Timestamp getDate_edited() {
		return date_edited;
	}

	public void setDate_edited(Timestamp date_edited) {
		this.date_edited = date_edited;
	}
	
	
	
	
	
	
	
	

}
