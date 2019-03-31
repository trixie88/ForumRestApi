package com.forum.messages.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.forum.messages.entities.Token;

@CrossOrigin("*")
@RepositoryRestResource
public interface TokenRepository extends JpaRepository<Token, Integer> {

	Token findByAlphaNumeric(String alphaNumeric);
}
