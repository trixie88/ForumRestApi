package com.forum.messages.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="username")
public class User  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2706039142809630665L;

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column (name="name")
	private String name;
	
	@Column (name="surname")
	private String surname;
	
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="level")
	private int level;
	
	@NotNull
	@Column(name="banned")
	private int banned;
	
	@NotNull
	@Column(name="enabled")
	private int enabled;
	
	@OneToMany(mappedBy="from_user")
	@JsonIgnore
	private List<Message> sentMessages;
	
	@OneToMany(mappedBy="to_user")
	@JsonIgnore
	private List<Message> inbox;
	
	@OneToMany(mappedBy="last_editor")
	@JsonIgnore
	private List<Message> editedMessages;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<DeletedMessage> deletedMessages;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<ThreadMessage> threadMessages;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="blockerUser")
	@JsonIgnore
	private List<Blocked> blockedUsers;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="blockedUser")
	@JsonIgnore
	private List<Blocked> usersThatHaveBlockedMe;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Token> tokens;
	
	public User () {
	}

	public User(String username, String password, String name, String surname, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.level = 0;
		this.banned = 0;
		this.enabled=0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getBanned() {
		return banned;
	}

	public void setBanned(int banned) {
		this.banned = banned;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	
	
	
	

}
