package com.forum.messages.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="block")
public class Blocked  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9176177909308742908L;

	@EmbeddedId
	private BlockedEmbeddableID id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="blocker", insertable = false, updatable = false)
	private User blockerUser;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="blocked", insertable = false, updatable = false)
	private User blockedUser;
	
	public Blocked() {}

	public Blocked(User blockerUser, User blockedUser) {
		this.blockerUser = blockerUser;
		this.blockedUser = blockedUser;
	}

	public User getBlockerUser() {
		return blockerUser;
	}

	public void setBlockerUser(User blockerUser) {
		this.blockerUser = blockerUser;
	}

	public User getBlockedUser() {
		return blockedUser;
	}

	public void setBlockedUser(User blockedUser) {
		this.blockedUser = blockedUser;
	}

	

	
	
	
	
	
}
