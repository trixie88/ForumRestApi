package com.forum.messages.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.forum.messages.entities.DeletedMessage;

@CrossOrigin("*")
@RepositoryRestResource
public interface DeletedMessagesRepository extends JpaRepository<DeletedMessage, Integer> {

}
