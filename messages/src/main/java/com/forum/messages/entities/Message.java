package com.forum.messages.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="message_id")
	private int message_id;
	
	@ManyToOne
	@JoinColumn(name="from_user", nullable=false)
	private User from_user;
	
	@ManyToOne
	@JoinColumn(name="to_user", nullable=false)
	private User to_user;
	
	@Column(name="message")
	private String text;
	
	@NotNull
	@Column(name="date")
	private Timestamp date;
	
	@NotNull
	@Column(name="edited")
	private int edited;
	
	@Column(name="date_edited")
	private Timestamp date_edited;
	
	@ManyToOne
	@JoinColumn(name="last_editor")
	private User last_editor;
	
	@NotNull
	@Column(name="seen")
	private int seen;
	
	@OneToMany(mappedBy="deletedMessage")
	@JsonIgnore
	private List <DeletedMessage> deletedMessages;

	
	public Message() {}
	
	public Message(User from_user, User to_user, String text) {
		this.from_user = from_user;
		this.to_user = to_user;
		this.text = text;
		this.date =  new Timestamp(System.currentTimeMillis());
		this.edited = 0;
		this.date_edited = null;
		this.last_editor = null;
		this.seen = 0;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public User getFrom_user() {
		return from_user;
	}

	public void setFrom_user(User from_user) {
		this.from_user = from_user;
	}

	public User getTo_user() {
		return to_user;
	}

	public void setTo_user(User to_user) {
		this.to_user = to_user;
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

	public User getLast_editor() {
		return last_editor;
	}

	public void setLast_editor(User last_editor) {
		this.last_editor = last_editor;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}

	
	
	
	
	
	
	
	

}
