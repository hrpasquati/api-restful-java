package com.br.henriquepasquati.restful.services;

import com.br.henriquepasquati.restful.domain.Post;
import com.br.henriquepasquati.restful.domain.User;
import com.br.henriquepasquati.restful.dto.UserDTO;
import com.br.henriquepasquati.restful.repository.PostRepository;
import com.br.henriquepasquati.restful.repository.UserRepository;
import com.br.henriquepasquati.restful.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullsearch(text, minDate, maxDate);
    }

}
