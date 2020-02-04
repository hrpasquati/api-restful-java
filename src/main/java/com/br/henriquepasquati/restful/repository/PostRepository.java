package com.br.henriquepasquati.restful.repository;

import com.br.henriquepasquati.restful.domain.Post;
import com.br.henriquepasquati.restful.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
