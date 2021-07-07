package com.spring.codeblog.service.serviceImpl;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogServiceImpl implements CodeblogService {

    //Classe que e têm acesso ao SpringData ou seja acesso ao DB
    //Ponto de injeção
    @Autowired
    CodeBlogRepository codeblogRepository;

    @Override
    public List<Post> findAll() {
        return this.codeblogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return this.codeblogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return this.codeblogRepository.save(post);
    }
}
