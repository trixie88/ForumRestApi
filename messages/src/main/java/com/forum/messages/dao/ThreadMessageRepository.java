package com.forum.messages.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.forum.messages.entities.ThreadMessage;

@CrossOrigin("*")
@RepositoryRestResource
public interface ThreadMessageRepository extends JpaRepository<ThreadMessage, Integer> {

}
