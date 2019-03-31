package com.forum.messages.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.forum.messages.entities.Blocked;
import com.forum.messages.entities.BlockedEmbeddableID;

@CrossOrigin("*")
@RepositoryRestResource(path="blockedList")
public interface BlockedRepository extends JpaRepository<Blocked, Integer> {

}
