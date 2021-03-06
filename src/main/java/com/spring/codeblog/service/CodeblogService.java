package com.spring.codeblog.service;

import com.spring.codeblog.model.Post;

import java.util.List;

public interface CodeblogService {

    //Está implementado da Classe CodeblogServiceImpl
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
    Post updatePost(Post post);
    void delete(Post post);
}
