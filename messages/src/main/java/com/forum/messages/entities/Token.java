package com.forum.messages.entities;

import java.io.Serializable;
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
@Table(name="token")
public class Token  implements Serializable{

	
	private static final long serialVersionUID = 58416989143405486L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="token_id")
	private int tokenID;
	
	@NotNull
	@Column(name="alphanumeric")
	private String alphaNumeric;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	@NotNull
	@Column(name="date_of_creation")
	private Timestamp dateOfCreation;

	public Token() {}
	
	public Token( String alphaNumeric,  User user ) {
		this.alphaNumeric = alphaNumeric;
		this.user = user;
		this.dateOfCreation = new Timestamp(System.currentTimeMillis());
	}

	public int getTokenID() {
		return tokenID;
	}

	public void setTokenID(int tokenID) {
		this.tokenID = tokenID;
	}

	public String getAlphaNumeric() {
		return alphaNumeric;
	}

	public void setAlphaNumeric(String alphaNumeric) {
		this.alphaNumeric = alphaNumeric;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Timestamp dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	
	
	
}
