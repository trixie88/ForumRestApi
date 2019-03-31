package com.forum.messages.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BlockedEmbeddableID  implements Serializable{

	
	private static final long serialVersionUID = 416356156764850560L;

	@Basic(optional=false)
	@Column(name="blocker")
	private String blockerUsername;
	
	@Basic(optional=false)
	@Column(name="blocked")
	private String blockedUsername;

	public BlockedEmbeddableID() {
	}

	public String getBlockerUsername() {
		return blockerUsername;
	}

	public void setBlockerUsername(String blockerUsername) {
		this.blockerUsername = blockerUsername;
	}

	public String getBlockedUsername() {
		return blockedUsername;
	}

	public void setBlockedUsername(String blockedUsername) {
		this.blockedUsername = blockedUsername;
	}

	@Override
	public String toString() {
		return "BlockedEmbeddableID [blockerUsername=" + blockerUsername + ", blockedUsername=" + blockedUsername + "]";
	}
	
	
	
	
	
}
