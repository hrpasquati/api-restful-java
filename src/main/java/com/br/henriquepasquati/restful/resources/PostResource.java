package com.br.henriquepasquati.restful.resources;

import com.br.henriquepasquati.restful.domain.Post;
import com.br.henriquepasquati.restful.domain.User;
import com.br.henriquepasquati.restful.dto.UserDTO;
import com.br.henriquepasquati.restful.resources.util.URL;
import com.br.henriquepasquati.restful.services.PostService;
import com.br.henriquepasquati.restful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post user = service.findById(id);
        return ResponseEntity.ok().body(user);

    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = " ") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullseach(
            @RequestParam(value = "text", defaultValue = " ") String text,
            @RequestParam(value = "minDate", defaultValue = " ") String minDate,
            @RequestParam(value = "maxDate", defaultValue = " ") String maxDate){

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date(0L));
        List<Post> list = service.fullSearch(text, min, max);

        return ResponseEntity.ok().body(list);

    }

}