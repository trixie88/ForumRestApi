package com.forum.messages.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="deletedmessages")
public class DeletedMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="deleted_msg_id")
	private int deleted_msg_id;
	
	@ManyToOne
	@JoinColumn(name="message_id")
	private Message deletedMessage;
	
	
	@ManyToOne
	@JoinColumn(name="deleted_from_user")
	private User user;

	
	public DeletedMessage() {}
	
	
	public DeletedMessage(Message deletedMessage, User user) {
		this.deletedMessage = deletedMessage;
		this.user = user;
	}
	
	

	public int getDeleted_msg_id() {
		return deleted_msg_id;
	}

	public void setDeleted_msg_id(int deleted_msg_id) {
		this.deleted_msg_id = deleted_msg_id;
	}

	
	public Message getDeletedMessage() {
		return deletedMessage;
	}

	public void setDeletedMessage(Message deletedMessage) {
		this.deletedMessage = deletedMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
